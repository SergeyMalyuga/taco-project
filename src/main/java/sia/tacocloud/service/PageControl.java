package sia.tacocloud.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import sia.tacocloud.entyties.UserM;

public class PageControl {

    public boolean isLogged() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserM user = (UserM) authentication.getPrincipal();
        if (authentication != null && !("anonimus").equals(authentication.getName())) {
            return true;
        } else {
            return false;
        }
    }
}
