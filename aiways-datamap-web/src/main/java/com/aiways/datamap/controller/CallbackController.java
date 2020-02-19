package com.aiways.datamap.controller;

import com.aiways.platform.common.response.BaseResult;
import com.aiways.platform.common.response.ResultCode;
import com.aiways.platform.common.utils.ResultUtils;
import com.aiways.platform.upm.sdk.UpmManager;
import com.aiways.platform.upm.sdk.vo.CallBackVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: baifs
 * @date: 2019/7/18 18:42
 * @description: UPM集成回调接口
 */
@Slf4j
@RestController
public class CallbackController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    @SuppressWarnings("All")
    private HttpServletResponse response;


    @Value("${upm.client.secret}")
    private String clientSecret;

    @Value("${upm.client.index}")
    private String indexUrl;

    @Value("${upm.client.id}")
    private String clientId;

    /**
     *
     */
    @RequestMapping(value = "/upm/callback", method = RequestMethod.GET)
    public BaseResult callback(@RequestParam(name = "code",required = false) String code,
                               @RequestParam(name = "account",required = false) String account) throws IOException {

        if(StringUtils.isBlank(code) || StringUtils.isBlank(account)){
            log.info("CallbackController | callback code or account is empty ! time：{}",System.currentTimeMillis());
            return ResultUtils.failed(ResultCode.PARAM_ERROR);
        }
        UpmManager upmManager = UpmManager.getInstance();
        String signature = DigestUtils.sha256Hex(clientId + account + code + getClientSecret());
        com.aiways.platform.upm.sdk.dto.BaseResult<String> result = upmManager.token(clientId, account, code, signature);
        String token = result.getData();
        Cookie cookie = new Cookie("token", token);
        CallBackVO callBackVO = new CallBackVO();
        callBackVO.setIndexUrl(indexUrl);
        callBackVO.setToken(token);
        return ResultUtils.success(callBackVO);
    }

    private String getClientSecret() {
        return clientSecret;
    }
}

