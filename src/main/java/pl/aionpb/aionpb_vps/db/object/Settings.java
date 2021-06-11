package pl.aionpb.aionpb_vps.db.object;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author Grzegorz Nowakowski
 */
public class Settings {
    private String server;
    private String loca;

    public Settings() {
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getLoca() {
        return loca;
    }

    public void setLoca(String loca) {
        this.loca = loca;
    }

    public static String getServerId() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request;

        //TODO: clean this.
        //first check if url param is present. That needs to take priority.
        //then check if cookie exists and what is there.
        //if neither is preset, return 0.

        if (attr != null) {
            request = attr.getRequest();
        } else {
            return "0";
        }

        String parameter = request.getParameter("server");
        Cookie[] cookies = request.getCookies();

        //URL parameter is present. Return the parameter value.
        if (parameter != null) {
            if (parameter.equals("0") || parameter.equals("1")) {
                return parameter;
            }
        }

        //URL parameter is not present. Check Cookies.
        if (cookies != null) {
            //if AionPB.server cookie exists, return value as long as it's 0 or 1. Otherwise return 0.
            String value = Arrays.stream(cookies)
                    .filter(c -> c.getName().equals("AionPB.server"))
                    .findFirst()
                    .map(Cookie::getValue)
                    .orElse("0");


            if (value.equals("0") || value.equals("1")) {
                return value;
            } else {
                return "0";
            }
        }

        return "0";
    }

    public static String getLocaCode() {
        return LocaleContextHolder.getLocale().getLanguage();
    }
}
