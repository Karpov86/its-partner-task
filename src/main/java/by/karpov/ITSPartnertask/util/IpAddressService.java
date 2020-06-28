package by.karpov.ITSPartnertask.util;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class IpAddressService {

    public String getClientIp(HttpServletRequest request) {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
}