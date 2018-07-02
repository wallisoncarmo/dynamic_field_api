package com.carmowallison.dynamic_field_api.config;

import com.carmowallison.dynamic_field_api.domain.*;
import com.carmowallison.dynamic_field_api.domain.enums.Perfil;
import com.carmowallison.dynamic_field_api.repositoties.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;

@Configuration

public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CampoRepository campoRepository;
    @Autowired
    private TipoCampoRepository tipoCampoRepository;
    @Autowired
    private TipoPaginaRepository tipoPaginaRepository;
    @Autowired
    private ValorRepository valorRepository;
    @Autowired
    private PaginaRepository paginaRepository;

    @Autowired
    private BCryptPasswordEncoder bc;

    @Override
    public void run(String... args) throws Exception {

        // EXCLUIR TODA A BASE
//        userRepository.deleteAll();
//        campoRepository.deleteAll();
//        tipoCampoRepository.deleteAll();
//        tipoPaginaRepository.deleteAll();
//        valorRepository.deleteAll();
//        paginaRepository.deleteAll();


        System.out.println("======================================================");
        System.out.println("CRIA NOVA BASE");

        System.out.println("Usuários basicos");
        // BLOCO USUARIOS
        User wallison = new User(null, "Wallison do Carmo Costa", "admin@email.com", true, bc.encode("123"));
        wallison.addPerfil(Perfil.ADMIN);
        wallison.addPerfil(Perfil.MEDICO);
        wallison.addPerfil(Perfil.PERITO);

        User yasmin = new User(null, "yasmin", "yasmin@gmail.com", false, bc.encode("123"));
        yasmin.addPerfil(Perfil.MEDICO);

        User lucy = new User(null, "lucy", "lucy@gmail.com", true, bc.encode("123"));
        lucy.addPerfil(Perfil.MEDICO);
        lucy.addPerfil(Perfil.PERITO);
        //userRepository.saveAll(Arrays.asList(wallison, yasmin, lucy));

        System.out.println("Tipo Pagina basicos");
        TipoPagina pagina = new TipoPagina(null,"pagina");
        TipoPagina tab = new TipoPagina(null,"tab");

        //tipoPaginaRepository.saveAll(Arrays.asList(pagina,tab));
        System.out.println("[pagina][tab]");

        System.out.println("Tipo Pagina basicos");
        TipoCampo email = new TipoCampo(null,"email");
        TipoCampo password = new TipoCampo(null,"password");
        TipoCampo oneSelect = new TipoCampo(null,"oneSelect");
        TipoCampo multiSelect = new TipoCampo(null,"multiSelect");
        TipoCampo radio = new TipoCampo(null,"radio");
        TipoCampo checkBox = new TipoCampo(null,"checkBox");
        TipoCampo text = new TipoCampo(null,"text");
        TipoCampo number = new TipoCampo(null,"number");
        TipoCampo file = new TipoCampo(null,"file");
        TipoCampo chips = new TipoCampo(null,"chips");

        //tipoCampoRepository.saveAll(Arrays.asList(email,password,oneSelect,multiSelect,radio,checkBox,text,number,file,chips));
        System.out.println("[email] [password] [oneSelect] [multiSelect] [radio] [checkBox] [text] [number] [file]");

        System.out.println("Valores para tipo de campos");
        Valor select_email = new Valor(null,"email",null);
        Valor select_password = new Valor(null,"password",null);
        Valor select_oneSelect = new Valor(null,"oneSelect",null);
        Valor select_multiSelect = new Valor(null,"multiSelect",null);
        Valor select_radio = new Valor(null,"radio",null);
        Valor select_checkBox = new Valor(null,"checkBox",null);
        Valor select_text = new Valor(null,"text",null);
        Valor select_file = new Valor(null,"file",null);
        Valor select_chips = new Valor(null,"chips",null);

        List<Valor> tipo_campos = Arrays.asList(select_email,select_oneSelect,select_multiSelect,select_radio,select_checkBox,select_text,select_file,select_chips,select_password);
        //valorRepository.saveAll(tipo_campos);

        System.out.println("Valores para tipo de campos");
        Valor select_nome_campo = new Valor(null,"nome_campo",null);
        Valor select_titulo = new Valor(null,"titulo",null);
        Valor select_tipo_campo = new Valor(null,"tipo_campo",null);

        List<Valor> dependes = Arrays.asList(select_email,select_oneSelect,select_multiSelect,select_radio,select_checkBox,select_text,select_file,select_chips,select_password);
        //valorRepository.saveAll(dependes);

        System.out.println("Adiciona os valores para tipo de campos");

        Campo login = new Campo(null,"email","email",email,true,false,255,5,null,null);
        Campo senha = new Campo(null,"senha","senha",password,true,false,255,5,null,null);

        Campo nome_campo = new Campo(null,"nome_campo","Nome do Campo",text,true,false,255,5,null,null);
        Campo titulo = new Campo(null,"titulo","Titulo",text,true,false,255,5,null,null);
        Campo tipo_campo = new Campo(null,"tipo_campo","Tipo de Campo",oneSelect,true,false,255,5,null,tipo_campos);
        Campo obrigatorio = new Campo(null,"obrigatorio","Campo obrigatório?",radio,true,false,255,5,null,null);
        Campo dinamico = new Campo(null,"dinamico","Campo dinamico?",radio,true,false,255,5,null,null);
        Campo max = new Campo(null,"max","Máximo de caracter",number,true,false,255,5,null,null);
        Campo min = new Campo(null,"min","Mínimo de caracter",number,true,false,255,5,null,null);
        Campo depende = new Campo(null,"depende","Depende",oneSelect,false,false,255,5,null,dependes);
        Campo valores = new Campo(null,"valores","Valores",chips,false,false,255,5,null,null);


        //campoRepository.saveAll(Arrays.asList(login,senha,nome_campo,obrigatorio,tipo_campo,dinamico,max,min,valores,depende));

        System.out.println("Adiciona uma página");

        Pagina loginPage = new Pagina(null,"Login","login",Arrays.asList(login,senha));
        Pagina campoPage = new Pagina(null,"Login","login",Arrays.asList(nome_campo,obrigatorio,tipo_campo,dinamico,max,min,depende,valores));

       // paginaRepository.saveAll(Arrays.asList(loginPage,campoPage));

        System.out.println("[LOGIN] [CAMPO]");
        System.out.println("======================================================");
    }


}
