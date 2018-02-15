package com.arquitetura.DTO;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@XmlRootElement
public class MessageDTO implements Serializable {

    private static final long serialVersionUID = -7743657152986843799L;

    @XmlAttribute(name = "msg")
    @JsonProperty("msg")
    private String messagem;

    @XmlAttribute(name = "success")
    @JsonProperty("success")
    private Boolean success;

    @XmlAttribute(name = "conteudo")
    @JsonProperty("conteudo")
    private Object conteudo;

    public MessageDTO() {
        super();
    }

    public MessageDTO(Boolean success) {
        super();
        this.success = success;
    }

    public MessageDTO(String messagem) {
        super();
        this.messagem = messagem;
    }

    public MessageDTO(String messagem, Boolean success) {
        super();
        this.messagem = messagem;
        this.success = success;
    }

    public MessageDTO(String messagem, Boolean success, Object conteudo) {
        super();
        this.messagem = messagem;
        this.success = success;
        this.conteudo = conteudo;
    }

    public Object getConteudo() {
        return conteudo;
    }

    public String getMessagem() {
        return messagem;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setConteudo(Object conteudo) {
        this.conteudo = conteudo;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}