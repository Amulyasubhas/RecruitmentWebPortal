
package com.recruit.springboot.RecruitmentWebPortal.serviceimpl;

import com.recruit.springboot.RecruitmentWebPortal.DTO.*;
import com.recruit.springboot.RecruitmentWebPortal.entity.Employee;
import com.recruit.springboot.RecruitmentWebPortal.repository.EmployeeRepository;
import com.recruit.springboot.RecruitmentWebPortal.security.CustomUserDetailsService;
import com.recruit.springboot.RecruitmentWebPortal.security.JwtUtil;
import com.recruit.springboot.RecruitmentWebPortal.service.AuthService;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.recruit.springboot.RecruitmentWebPortal.DTO.ConfirmResetPasswordDTO;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
private PasswordEncoder passwordEncoder;

@Autowired
private JwtUtil jwtUtil;

@Autowired
private CustomUserDetailsService userDetailsService;

// In-memory OTP store
    private final Map<String, OtpDetails> otpMap = new HashMap<>();

    // OTP expires in 5 minutes
    private static final Duration OTP_EXPIRY_DURATION = Duration.ofMinutes(5);

    // Helper class to store OTP + timestamp
    private static class OtpDetails {
        private final String otp;
        private final LocalDateTime timestamp;

        public OtpDetails(String otp, LocalDateTime timestamp) {
            this.otp = otp;
            this.timestamp = timestamp;
        }

        public String getOtp() {
            return otp;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }
    }

    //  Send OTP for login
   @Override
public String sendLoginOtp(LoginRequestDTO dto) {
    Optional<Employee> empOpt = employeeRepository.findByEmail(dto.getEmail());

    if (empOpt.isEmpty()) {
        return "Email not found.";
    }
    String otp = String.valueOf(new Random().nextInt(900000) + 100000);
    otpMap.put(dto.getEmail(), new OtpDetails(otp, LocalDateTime.now()));

    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(dto.getEmail());
    message.setSubject("Login OTP");
    message.setText("Your OTP for login is: " + otp + "\nIt will expire in 5 minutes.");
    message.setFrom("no-reply@recruitportal.com");
    mailSender.send(message);

    return "OTP sent to your email.";
}

    @Override
public String resendLoginOtp(String email) {
    Optional<Employee> empOpt = employeeRepository.findByEmail(email);

    if (empOpt.isEmpty()) {
        return "Email not found.";
    }

    String otp = String.valueOf(new Random().nextInt(900000) + 100000);
    otpMap.put(email, new OtpDetails(otp, LocalDateTime.now()));

    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(email);
    message.setSubject("Resend Login OTP");
    message.setText("Your OTP for login is: " + otp + "\nIt will expire in 5 minutes.");
    message.setFrom("no-reply@recruitportal.com");
    mailSender.send(message);

    return "OTP resent to your email.";
}


    //  Verify login OTP
    @Override
    public String verifyLoginOtp(OtpVerificationDTO dto) {
        OtpDetails otpDetails = otpMap.get(dto.getEmail());
        if (otpDetails == null) {
            return "OTP not found or expired.";
        }

        if (!otpDetails.getOtp().equals(dto.getOtp())) {
            return "Invalid OTP.";
        }

        if (Duration.between(otpDetails.getTimestamp(), LocalDateTime.now()).compareTo(OTP_EXPIRY_DURATION) > 0) {
            otpMap.remove(dto.getEmail());
            return "OTP has expired.";
        }

        return "OTP verified. Please enter your password to login.";
    }

    // Login with password
   @Override
public LoginResponseDTO loginWithPassword(String email, String password) {
    Optional<Employee> empOpt = employeeRepository.findByEmail(email);

    if (empOpt.isEmpty()) {
        return new LoginResponseDTO("Email not found.", null);
    }

    Employee emp = empOpt.get();
    if (!passwordEncoder.matches(password, emp.getPassword())) {
        return new LoginResponseDTO("Incorrect password.", null);
    }

    UserDetails userDetails = userDetailsService.loadUserByUsername(email);
    String token = jwtUtil.generateToken(userDetails);

    return new LoginResponseDTO("Login successful!", token);
}

//forgot password
    @Override
public String forgotPassword(ForgotPasswordDTO dto) {
    Optional<Employee> empOpt = employeeRepository.findByEmail(dto.getEmail());
    if (empOpt.isEmpty()) {
        return "Email not found!";
    }

    // Generate OTP
    String otp = String.valueOf(new Random().nextInt(900000) + 100000);
    otpMap.put(dto.getEmail(), new OtpDetails(otp, LocalDateTime.now()));

    // Send OTP via email
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(dto.getEmail());
    message.setSubject("Reset Password OTP");
    message.setText("Your OTP is: " + otp + "\nIt will expire in 5 minutes.");
    message.setFrom("no-reply@recruitportal.com");
    mailSender.send(message);

    return "OTP sent to your email.";
}

//resend otp if in case forgot password otp expires 
    @Override
public String resendOtp(String email) {
    Optional<Employee> empOpt = employeeRepository.findByEmail(email);
    if (empOpt.isEmpty()) {
        return "Email not found.";
    }

    String otp = String.valueOf(new Random().nextInt(900000) + 100000);
    otpMap.put(email, new OtpDetails(otp, LocalDateTime.now()));

    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(email);
    message.setSubject("Resent OTP - Reset Password");
    message.setText("Your new OTP is: " + otp + "\nIt will expire in 5 minutes.");
    message.setFrom("no-reply@recruitportal.com");
    mailSender.send(message);

    return "New OTP sent to your email.";
}


    //  Verify OTP and reset password with confirm check
   @Override
public String verifyOtpAndResetPassword(ConfirmResetPasswordDTO dto) {
    OtpDetails otpDetails = otpMap.get(dto.getEmail());
    if (otpDetails == null) {
        return "OTP not found or expired.";
    }

    if (!otpDetails.getOtp().equals(dto.getOtp())) {
        return "Invalid OTP.";
    }

    if (Duration.between(otpDetails.getTimestamp(), LocalDateTime.now()).compareTo(OTP_EXPIRY_DURATION) > 0) {
        otpMap.remove(dto.getEmail());
        return "OTP has expired. Please request a new one.";
    }

    if (!dto.getConfirmPassword().equals(dto.getConfirmPassword())) {
        return "New Password and Confirm Password do not match.";
    }

    return employeeRepository.findByEmail(dto.getEmail())  // Now works if getEmail() returns String
            .map(emp -> {
                emp.setPassword(passwordEncoder.encode(dto.getConfirmPassword())); // Optional: encode
                employeeRepository.save(emp);
                otpMap.remove(dto.getEmail());
                return "Password reset successful!";
            })
            .orElse("User not found.");
}
}
