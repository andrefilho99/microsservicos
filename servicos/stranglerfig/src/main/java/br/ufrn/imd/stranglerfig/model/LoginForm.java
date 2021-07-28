package br.ufrn.imd.stranglerfig.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created By Zhu Lin on 1/1/2019.
 */
@Data
public class LoginForm {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
