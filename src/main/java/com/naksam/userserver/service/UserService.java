package com.naksam.userserver.service;

import com.naksam.userserver.common.HttpSupport;
import com.naksam.userserver.domain.UserDomain;
import com.naksam.userserver.dto.JsonWebToken;
import com.naksam.userserver.dto.MemberPayload;
import com.naksam.userserver.dto.UserDetailResponse;
import com.naksam.userserver.feign.AccountRetryClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@AllArgsConstructor
public class UserService {
    private final UserDomain userDomain;
    private final AccountRetryClient accountRetryClient;
    private static final String COOKIE_NAME = "naksam";

    public UserDetailResponse findDetail(HttpServletRequest req) {
        MemberPayload memberPayload = getMemberPayload(req);
        return userDomain.findDetail(memberPayload.getId())
                .createUserDetail();

//        return userDomain.findDetail(1L)
//                .createUserDetail();
    }

    public UserDetailResponse findByEmail(String email){
        return userDomain.findByEmail(email).createUserDetail();
    }

    private MemberPayload getMemberPayload(HttpServletRequest req) {
        String token = HttpSupport.getToken(req, COOKIE_NAME);

        System.out.println(token);

        return accountRetryClient.findInfo(new JsonWebToken(token));
    }
}
