package com.naksam.userserver.feign;

import com.naksam.userserver.config.FeignConfiguration;
import com.naksam.userserver.config.FeignRetryConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "retry", url="${ACCOUNT_HOST:http://naksam.169.56.174.130.nip.io/account}", configuration = {FeignConfiguration.class, FeignRetryConfiguration.class})
public interface AccountRetryClient extends AccountClient {

}
