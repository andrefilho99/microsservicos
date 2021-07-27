package service.request;

import model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserRequest {

    @Value("${acesso.ms.monolito}")
    private String HOST_MS_MONOLITO;

    public User findOneUser(String email){
        String url = String.format("%s/api/getone/%s", HOST_MS_MONOLITO, email);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, User.class);
    }
}
