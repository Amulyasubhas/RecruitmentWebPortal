// package com.recruit.springboot.RecruitmentWebPortal.controller;
// import com.recruit.springboot.RecruitmentWebPortal.DTO.ForgotPasswordDTO;
// import com.recruit.springboot.RecruitmentWebPortal.DTO.LoginRequestDTO;
// import com.recruit.springboot.RecruitmentWebPortal.DTO.OtpVerificationDTO;
// import com.recruit.springboot.RecruitmentWebPortal.DTO.ResetPasswordDTO;
// import com.recruit.springboot.RecruitmentWebPortal.entity.Employee;
// import com.recruit.springboot.RecruitmentWebPortal.service.AuthService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @Autowired
//     private AuthService authService;

//     @PostMapping("/send-login-otp")
//     public String sendLoginOtp(@RequestBody LoginRequestDTO dto) {
//         return authService.sendLoginOtp(dto);
//     }

//     @PostMapping("/verify-login-otp")
//     public String verifyLoginOtp(@RequestBody OtpVerificationDTO dto) {
//         return authService.verifyLoginOtp(dto);
//     }

//     @PostMapping("/login-password")
//     public String loginWithPassword(@RequestParam String email, @RequestParam String password) {
//         return authService.loginWithPassword(email, password);
//     }


//     @PostMapping("/forgot-password")
//     public String forgotPassword(@RequestBody ForgotPasswordDTO dto) {
//         return authService.forgotPassword(dto);
//     }

//     @PostMapping("/send-reset-otp")
//     public String sendResetOtp(@RequestParam String email) {
//         return authService.sendResetOtp(email);
//     }

//     @PostMapping("/verify-reset-password")
//     public String verifyOtpAndResetPassword(@RequestBody ResetPasswordDTO dto) {
//         return authService.verifyOtpAndResetPassword(dto);
//     }
// }


package com.recruit.springboot.RecruitmentWebPortal.controller;

import com.recruit.springboot.RecruitmentWebPortal.DTO.*;
import com.recruit.springboot.RecruitmentWebPortal.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/send-login-otp")
    public String sendLoginOtp(@RequestBody LoginRequestDTO dto) {
        return authService.sendLoginOtp(dto);
    }
    @PostMapping("/resend-login-otp")
public String resendLoginOtp(@RequestParam String email) {
    return authService.resendLoginOtp(email);
}


    @PostMapping("/verify-login-otp")
    public String verifyLoginOtp(@RequestBody OtpVerificationDTO dto) {
        return authService.verifyLoginOtp(dto);
    }

    @PostMapping("/login-password")
    public String loginWithPassword(@RequestParam String email, @RequestParam String password) {
        return authService.loginWithPassword(email, password);
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestBody ForgotPasswordDTO dto) {
        return authService.forgotPassword(dto);
    }

    @PostMapping("/send-reset-otp")
    public String sendResetOtp(@RequestParam String email) {
        return authService.sendResetOtp(email);
    }

    @PostMapping("/verify-reset-password")
    public String verifyOtpAndResetPassword(@RequestBody ConfirmResetPasswordDTO dto) {  
        return authService.verifyOtpAndResetPassword(dto);
    }
}
