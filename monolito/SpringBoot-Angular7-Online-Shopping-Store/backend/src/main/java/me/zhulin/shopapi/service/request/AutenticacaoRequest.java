package me.zhulin.shopapi.service.request;

import me.zhulin.shopapi.vo.request.JwtResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class AutenticacaoRequest {

    @Value("${acesso.ms.autenticacao}")
    private String HOST_MS_AUTENTICACAO;

    public JwtResponse login(String nome, String senha){
        String url = String.format("%s/api/login", HOST_MS_AUTENTICACAO);

        MultiValueMap<String, Object> parametros = new LinkedMultiValueMap<String, Object>();
        parametros.add("nome", nome);
        parametros.add("senha", senha);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForEntity(url, parametros, JwtResponse.class).getBody();
    }
}
