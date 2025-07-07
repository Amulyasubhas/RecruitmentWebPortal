// package com.recruit.springboot.RecruitmentWebPortal.service;

// import com.recruit.springboot.RecruitmentWebPortal.DTO.*;

// public interface AuthService {
//     String sendLoginOtp(LoginRequestDTO dto);
//     String verifyLoginOtp(OtpVerificationDTO dto);
//     String loginWithPassword(String email, String password);

//     String forgotPassword(ForgotPasswordDTO dto);
//     String sendResetOtp(String email);
//     String verifyOtpAndResetPassword(ResetPasswordDTO dto);
// }
package com.recruit.springboot.RecruitmentWebPortal.service;

import com.recruit.springboot.RecruitmentWebPortal.DTO.*;

public interface AuthService {
    String sendLoginOtp(LoginRequestDTO dto);
    String resendLoginOtp(String email);

    String verifyLoginOtp(OtpVerificationDTO dto);
    String loginWithPassword(String email, String password);
    String forgotPassword(ForgotPasswordDTO dto);
    String sendResetOtp(String email);
    String verifyOtpAndResetPassword(ConfirmResetPasswordDTO dto); // ✅ Updated
}
