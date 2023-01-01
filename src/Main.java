import Classes.*;
import repository.*;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Object usuarioLogado = chamaSelecaoUsuario();
        checaSenhaUsuario(usuarioLogado);
    }

    private static void chamaMenuCadastros() {

        // MENU DE CADASTRO DE USUARIO

        String[] opcoesMenuCadastro = {"Cliente", "Colaborador", "Produto", "Serviço", "Venda/Produtos", "Venda/Serviços", "Voltar"};
        int menuCadastro = JOptionPane.showOptionDialog(null, "❰SGMC❱\n\nEscolha uma opção de cadastro: ",
                "Menu Cadastros",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadastro, opcoesMenuCadastro[0]);

        switch (menuCadastro) {
            case 0 -> { // CADASTRO DE CLIENTE
                Cliente cliente = chamaCadastroCliente();
                if (cliente != null) getClienteDAO().salvar(cliente);
                chamaMenuCadastros();
            }
            case 1 -> { //CADASTRO DE COLABORADOR
                Colaborador colaborador = chamaCadastroColaborador();
                if (colaborador != null) getColaboradorDAO().salvar(colaborador);
                chamaMenuCadastros();
            }
            case 2 -> { // CADASTRO DE PRODUTOS
                Produto produto = chamaCadastroProduto();
                if (produto != null) getProdutoDAO().salvar(produto);
                chamaMenuCadastros();
            }
            case 3 -> { // CADASTRO DE SERVICO
                Servico servico = chamaCadastroServico();
                if (servico != null) getServicoDAO().salvar(servico);
                chamaMenuCadastros();
            }
            case 4 -> { // CADASTRO DE UMA VENDA
                Venda venda = chamaCadastroVendaProdutos();
                VendaDAO.salvar(venda);
                chamaMenuCadastros();
            }
            case 5 -> { //CADASTRO DE UMA VENDA DE SERVIÇOS
                Venda venda = chamaCadastroVendaServicos();
                VendaDAO.salvar(venda);
                chamaMenuCadastros();
            }
            case 6 -> // VOLTAR
                    chamaMenuPrincipal();
        }
    }
    private static Integer chamaOpcaoCrud() {
        String[] opcao = {"Inserção", "Alteração", "Exclusão"};
        int tipoOpcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Operação no cadastro: ",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcao, opcao[0]);
        return tipoOpcao;
    }

    public static ClienteDAO getClienteDAO() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO;
    }

    public static ColaboradorDAO getColaboradorDAO() {
        ColaboradorDAO colaboradorDAODAO = new ColaboradorDAO();
        return colaboradorDAODAO;
    }

    public static ProdutoDAO getProdutoDAO() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO;
    }

    public static ServicoDAO getServicoDAO(){
        ServicoDAO servicoDAO = new ServicoDAO();
        return servicoDAO;
    }

    private static Cliente chamaCadastroCliente() {
        Integer opcaoCrud = chamaOpcaoCrud();
        Cliente cliente;
        switch (opcaoCrud) {
            case 0: //Inserção
                cliente = chamaNovoCliente();
                break;
            case 1: //Alteração
                cliente = selecaoDeCliente();
                cliente = editaCliente(cliente);
                break;
            default: //Exclusão
                cliente = selecaoDeCliente();
                getClienteDAO().remover(cliente);
                cliente = null;
                break;
        }
        return cliente;
    }

    private static Cliente chamaNovoCliente() {

        // MENU DE CADASTRO DE CLIENTE

        String nome = null;
        String documento = null;

        nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente: ");
        documento = JOptionPane.showInputDialog(null, "Digite o CPF do cliente: ");

        Cliente cliente = new Cliente();
        cliente.setNomeCliente(nome);
        cliente.setCpf(documento);
        return cliente;

        }

    private static Cliente editaCliente(Cliente clienteEdit) {

        String nome = JOptionPane.showInputDialog(null, "Digite o nome da pessoa: ", clienteEdit.getNomeCliente());
        String documento = JOptionPane.showInputDialog(null, "Digite o CPF da pessoa: ", clienteEdit.getCpf());

        Cliente cliente = new Cliente();
        cliente.setNomeCliente(nome);
        cliente.setCpf(documento);
        return cliente;

        }

    private static Cliente selecaoDeCliente() {
        Object[] selectionValues = getClienteDAO().findPessoasInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o cliente:",
                "❰SGMC❱", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Cliente> pessoas = getClienteDAO().buscarPorNome((String) selection);
        return pessoas.get(0);
    }

    private static Colaborador chamaCadastroColaborador() {
        Integer opcaoCrud = chamaOpcaoCrud();
        Colaborador colaborador;
        switch (opcaoCrud) {
            case 0: //Inserção
                colaborador = chamaNovoColaborador();
                break;
            case 1: //Alteração
                colaborador = selecaoDeColaborador();
                colaborador = editaColaborador(colaborador);
                break;
            default: //Exclusão
                colaborador = selecaoDeColaborador();
                getColaboradorDAO().remover(colaborador);
                colaborador = null;
                break;
        }
        return colaborador;
    }

    private static Colaborador chamaNovoColaborador() {

        String nome = null;
        String documento = null;

        nome = JOptionPane.showInputDialog(null, "Digite o nome do colaborador: ");
        documento = JOptionPane.showInputDialog(null, "Digite a matricula do colaborador: ");
        String cargo = JOptionPane.showInputDialog(null, "Digite o cargo do colaborador: ");
        String situacao = JOptionPane.showInputDialog(null, "Digite a situação do colaborador: ");
        String dt = JOptionPane.showInputDialog(null, "Digite a data de admissão  do colaborador: ");

        Colaborador colaborador = new Colaborador();
        colaborador.setTipo(TipoPessoa.COLABORADOR);
        colaborador.setNomeColaborador(nome);
        colaborador.setMatricula(documento);
        colaborador.setCargoColaborador(cargo);
        colaborador.setSituacao(situacao);
        colaborador.setDt_admissao(dt);
        return colaborador;
    }

    private static Colaborador editaColaborador(Colaborador colaboradorEdit) {

        String nome = null;
        String documento = null;

        nome = JOptionPane.showInputDialog(null, "Digite o nome do colaborador: ", colaboradorEdit.getNomeColaborador());
        documento = JOptionPane.showInputDialog(null, "Digite a matricula do colaborador: ", colaboradorEdit.getDocumento());
        String cargo = JOptionPane.showInputDialog(null, "Digite o cargo do colaborador: ", colaboradorEdit.getCargoColaborador());
        String situacao = JOptionPane.showInputDialog(null, "Digite a situação do colaborador: ", colaboradorEdit.getSituacao());
        String dt = JOptionPane.showInputDialog(null, "Digite a data de admissão  do colaborador: ", colaboradorEdit.getDt_admissao());

        Colaborador colaborador = new Colaborador();
        colaborador.setTipo(TipoPessoa.COLABORADOR);
        colaborador.setNomeColaborador(nome);
        colaborador.setMatricula(documento);
        colaborador.setCargoColaborador(cargo);
        colaborador.setSituacao(situacao);
        colaborador.setDt_admissao(dt);
        return colaborador;
    }

    private static Colaborador selecaoDeColaborador() {
        Object[] selectionValues = getColaboradorDAO().findPessoasInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o colaborador:",
                "❰SGMC❱", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Colaborador> colaborador = getColaboradorDAO().buscarPorNome((String) selection);
        return colaborador.get(0);
    }

    private static Produto chamaCadastroProduto() {
        Integer opcaoCrud = chamaOpcaoCrud();
        Produto produto;
        switch (opcaoCrud) {
            case 0: //Inserção
                produto = chamaNovoProduto();
                break;
            case 1: //Alteração
                produto = selecaoDeProduto();
                produto = editaProduto(produto);
                break;
            default: //Exclusão
                produto = selecaoDeProduto();
                getProdutoDAO().remover(produto);
                produto = null;
                break;
        }
        return produto;
    }

    private static Produto selecaoDeProduto() {
        Object[] selectionValues = getProdutoDAO().findProdutoInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o produto:",
                "❰SGMC❱", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Produto> produtos = getProdutoDAO().buscarPorNome((String) selection);
        return produtos.get(0);
    }


    private static Produto chamaNovoProduto() {

        // MENU DE CADASTRO DE PRODUTOS

        String nomeProd = JOptionPane.showInputDialog(null, "Digite o nome do produto: : ");
        Integer quantidadeProduto = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite a quantidade de produto: "));
        String marcaProd = JOptionPane.showInputDialog(null, "Digite a marca do produto: ");
        Double precoProd = Double.valueOf(JOptionPane.showInputDialog(null, "Digite o valor do produto: "));

        Produto produto = new Produto();
        produto.setNomeProd(nomeProd);
        produto.setQuantidadeProdutoCadastrado(quantidadeProduto);
        produto.setMarcaProd(marcaProd);
        produto.setValorPod(precoProd);
        return produto;
    }

    private static Produto editaProduto(Produto produtoEdit) {

        String nomeProd = JOptionPane.showInputDialog(null, "Digite o nome do produto: : ", produtoEdit.getNomeProd());
        Integer quantidadeProduto = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite a quantidade de produto: ", produtoEdit.getQuantidadeProdutoCadastrado()));
        String marcaProd = JOptionPane.showInputDialog(null, "Digite a marca do produto: ", produtoEdit.getMarcaProd());
        Double precoProd = Double.valueOf(JOptionPane.showInputDialog(null, "Digite o valor do produto: ", produtoEdit.getValorPod()));

        Produto produto = new Produto();
        produto.setNomeProd(nomeProd);
        produto.setQuantidadeProdutoCadastrado(quantidadeProduto);
        produto.setMarcaProd(marcaProd);
        produto.setValorPod(precoProd);
        return produto;
    }

    private static Servico chamaCadastroServico() {
        Integer opcaoCrud = chamaOpcaoCrud();
        Servico servico;
        switch (opcaoCrud) {
            case 0: //Inserção
                servico = chamaNovoServico();
                break;
            case 1: //Alteração
                servico = selecaoDeServico();
                servico = editaServico(servico);
                break;
            default: //Exclusão
                servico = selecaoDeServico();
                getServicoDAO().remover(servico);
                servico = null;
                break;
        }
        return servico;
    }

    private static Servico selecaoDeServico() {
        Object[] selectionValuesServico = getServicoDAO().findServicoInArray();
        String initialSelectionSeguradora = (String) selectionValuesServico[0];
        Object selectionSeguradora = JOptionPane.showInputDialog(null, "Selecione a seguradora?",
                "SeguradoraAPP", JOptionPane.QUESTION_MESSAGE, null, selectionValuesServico, initialSelectionSeguradora);
        List<Servico> servicos = getServicoDAO().buscarPorNome((String) selectionSeguradora);
        return servicos.get(0);
    }

    private static Servico chamaNovoServico() {

        // MENU DE CADASTRO DE SERVICOS

        String nomeServico = JOptionPane.showInputDialog(null, "Digite um serviço oferecido: ");
        Double valorHorasTrab = Double.valueOf(JOptionPane.showInputDialog(null, "Digite o valor/Hora cobrado pelo serviço: "));

        Servico servico = new Servico();
        servico.setNomeServico(nomeServico);
        servico.setValorHoraTrab(valorHorasTrab);

        return servico;
    }

    private static Servico editaServico(Servico servicoEdit) {

        // MENU DE CADASTRO DE SERVICOS

        String nomeServico = JOptionPane.showInputDialog(null, "Digite um serviço oferecido: ", servicoEdit.getNomeServico());
        Double valorHorasTrab = Double.valueOf(JOptionPane.showInputDialog(null, "Digite o valor/Hora cobrado pelo serviço: ", servicoEdit.getValorHoraTrab()));

        Servico servico = new Servico();
        servico.setNomeServico(nomeServico);
        servico.setValorHoraTrab(valorHorasTrab);

        return servico;
    }

    private static Venda chamaCadastroVendaProdutos() {

        // MENU DE CADASTRO DE UMA VENDA

        // MENU DE NOTAS
        String[] opcaoNota = {"CUPOM FISCAL", "NOTA FISCAL"};
        int tipoNotaG = JOptionPane.showOptionDialog(null, "❰SGMC❱\n\nEscolha uma opção de venda: ",
                "Tipo Nota",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoNota, opcaoNota[0]);


        double desconto = 0.0;
        String formaPagamento = null;
        Double valorVenda = 0.0;
        int quantidadeP = 0;

        List<Produto> produtos = null;

        // CASO ESCOLHA NOTA FISCAL SERA EXECUTADO O CODIGO ABAIXO
        if (tipoNotaG == 1) {

            Object[] selectionValues = ClienteDAO.findPessoasInArray();
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o cliente da venda: ",
                    "<SGMC>\n CLIENTES", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
            List<Cliente> clientes = ClienteDAO.buscarPorNome((String) selection);
            Object[] selectionValuesProduto = ProdutoDAO.findProdutoInArray();
            String initialSelectionProduto = (String) selectionValues[0];
            Object selectionProduto = JOptionPane.showInputDialog(null, "Selecione o produto da venda: ",
                    "<SGMC>\n PRODUTOS", JOptionPane.QUESTION_MESSAGE, null, selectionValuesProduto, initialSelectionProduto);
            produtos = ProdutoDAO.buscarPorNome((String) selectionProduto);
            quantidadeP = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade: "));
            desconto = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o desconto: "));
            formaPagamento = JOptionPane.showInputDialog(null, "Digite a forma de pagamento: ");
        }

        // CASO ESCOLHA CUPOM FISCAL SERA EXECUTADO O CODIGO ABAIXO
        if (tipoNotaG == 0) {
            Object[] selectionValues = ClienteDAO.findPessoasInArray();
            Object[] selectionValuesProduto = ProdutoDAO.findProdutoInArray();
            String initialSelectionProduto = (String) selectionValues[0];
            Object selectionProduto = JOptionPane.showInputDialog(null, "Selecione o produto da venda: ",
                    "<SGMC>\n PRODUTOS", JOptionPane.QUESTION_MESSAGE, null, selectionValuesProduto, initialSelectionProduto);
            produtos = ProdutoDAO.buscarPorNome((String) selectionProduto);
            quantidadeP = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade: "));
            desconto = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o desconto: "));
            formaPagamento = JOptionPane.showInputDialog(null, "Digite a forma de pagamento: ");
        }

        Venda venda = new Venda();
        assert produtos != null;
        venda.setDescVenda(produtos.get(0).getNomeProd());
        venda.setValorProdutos(produtos.get(0).getValorPod());
        venda.setFormaPagamento(formaPagamento);
        venda.setDesconto(desconto);
        venda.setValorVenda(valorVenda);
        if(quantidadeP < produtos.get(0).getQuantidadeProdutoCadastrado()){
            venda.setQuantidadeP(quantidadeP);

        }else {

            JOptionPane.showMessageDialog(null, "Quantidade indisponivel em estoque.\n" +
                    "Venda cancelada, verifique a quantidade disponivel em estoque!");

        }

        return venda;

    }

    private static Venda chamaCadastroVendaServicos(){
        // MENU DE CADASTRO DE UMA VENDA DE SERVIÇOS

        // MENU DE NOTAS
        String[] opcaoNota = {"Cupom Fiscal", "Nota Fiscal"};
        int tipoNotaG = JOptionPane.showOptionDialog(null, "❰SGMC❱\n\nEscolha uma opção de venda: ",
                "Tipo Nota",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoNota, opcaoNota[0]);


        double desconto = 0.0;
        String formaPagamento = null;
        Double valorVenda = 0.0;
        int horasTrab = 0;

        List<Servico> servicos = null;

        // CASO ESCOLHA NOTA FISCAL SERA EXECUTADO O CODIGO ABAIXO
        if (tipoNotaG == 1) {

            Object[] selectionValues = ClienteDAO.findPessoasInArray();
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o cliente da venda: ",
                    "<SGMC>\n CLIENTES", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
            List<Cliente> clientes = ClienteDAO.buscarPorNome((String) selection);
            Object[] selectionValuesServico = ServicoDAO.findServicoInArray();
            String initialSelectionServico = (String) selectionValues[0];
            Object selectionServico = JOptionPane.showInputDialog(null, "Selecione o serviço que sera prestado: ",
                    "<SGMC>\n PRODUTOS", JOptionPane.QUESTION_MESSAGE, null, selectionValuesServico, initialSelectionServico);
            servicos = ServicoDAO.buscarPorNome((String) selectionServico);

            horasTrab = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de horas trabalhadas: "));
            desconto = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o desconto: "));


            formaPagamento = JOptionPane.showInputDialog(null, "Digite a forma de pagamento: ");
        }

        // CASO ESCOLHA CUPOM FISCAL SERA EXECUTADO O CODIGO ABAIXO
        if (tipoNotaG == 0) {
            Object[] selectionValues = ClienteDAO.findPessoasInArray();
            Object[] selectionValuesServico = ServicoDAO.findServicoInArray();
            String initialSelectionServico = (String) selectionValues[0];
            Object selectionServico = JOptionPane.showInputDialog(null, "Selecione o serviço que sera prestado: ",
                    "<SGMC>\n PRODUTOS", JOptionPane.QUESTION_MESSAGE, null, selectionValuesServico, initialSelectionServico);
            servicos = ServicoDAO.buscarPorNome((String) selectionServico);

            horasTrab = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de horas trabalhadas: "));
            desconto = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o desconto: "));
            formaPagamento = JOptionPane.showInputDialog(null, "Digite a forma de pagamento: ");
        }

        Venda venda = new Venda();
        assert servicos != null;
        venda.setDescVenda(servicos.get(0).getNomeServico());
        venda.setValorProdutos(servicos.get(0).getValorHoraTrab());
        venda.setFormaPagamento(formaPagamento);
        venda.setDesconto(desconto);
        venda.setValorVenda(valorVenda);
        venda.setQuantidadeP(horasTrab);

        return venda;
    }

    public static void chamaMenuRelatorios() {

        // MENU DE RELATORIO / HISTORIO

        String[] opcoesMenuProcesso = {"Cliente","Colaborador", "Produtos", "Serviços", "Vendas", "Voltar"};
        int menu_processos = JOptionPane.showOptionDialog(null, "❰SGMC❱\n\n Escolha uma opção de relatório: ",
                "Menu Relatórios",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuProcesso, opcoesMenuProcesso[0]);

        switch (menu_processos) {
            case 0 -> { //RELATORIO DE CLIENTES CADASTRADOS
                chamaRelatorioCliente();
                chamaMenuRelatorios();
            }
            case 1 -> { //RELATORIO DE COLABORADORES CADASTRADOS
                chamaRelatorioColaborador();
                chamaMenuRelatorios();
            }
            case 2 -> { //RELATORIO DE PRODUTOS CADASTRADOS
                chamaRelatorioProduto();
                chamaMenuRelatorios();
            }
            case 3 -> {//RELATORIO DE SERVICOS CADASTRADOS
                chamaRelatorioServicos();
                chamaMenuRelatorios();
            }

            case 4 -> { //RELATORIO DE VENDAS CADASTRADAS
                chamaRelatorioVendas();
                chamaMenuRelatorios();
            }
            case 5 -> //VOLTAR
                    chamaMenuPrincipal();
        }
    }

    private static void chamaRelatorioCliente() {

        // RELATORIO DE CLIENTES

        List<Cliente> clienteSalvas = ClienteDAO.buscarTodos();
        StringBuilder listaPessoas = new StringBuilder("Lista de Clientes");
        for (Cliente clienteSalva : clienteSalvas) {
            listaPessoas.append("\n").append(
                            "» Codigo: " + clienteSalva.getCodigoPessoa() + "\n" +
                            "» Nome: " + clienteSalva.getNomeCliente() + "\n" +
                            "» Tipo: " + clienteSalva.getTipo() + "\n" +
                            "» CPF: " + clienteSalva.getDocumento() + "\n__________________\n");
        }
        JOptionPane.showMessageDialog(null, listaPessoas.toString());
    }

    private static void chamaRelatorioColaborador() {

        // RELATORIO DE COLABORADOR

        List<Colaborador> colaboradorSalvo = ColaboradorDAO.buscarTodos();
        StringBuilder listaPessoas = new StringBuilder("Lista de Colaboradores");
        for (Pessoa Pessoa : colaboradorSalvo) {
            listaPessoas.append("\n").append(
                            "» Codigo: " + Pessoa.getCodigoPessoa() + "\n" +
                            "» Nome: " + Pessoa.getNomeColaborador() + "\n" +
                            "» Tipo de Usuario: " + Pessoa.getTipo() + "\n" +
                            "» Matricula: "+ Pessoa.getDocumento()+ "\n__________________\n");
        }
        JOptionPane.showMessageDialog(null, listaPessoas.toString());
    }

    private static void chamaRelatorioProduto() {

        // RELATORIO DE PRODUTOS CADASTRADOS

        List<Produto> produtos = ProdutoDAO.buscarTodos();
        StringBuilder lista = new StringBuilder("Lista de Produtos");
        for (Produto item : produtos) {
            lista.append("\n").append(
                    "» Codigo: " +item.getCodigoProdAleatorio() + "\n" +
                    "» Nome: " + item.getNomeProd() +"\n"+
                    "» Valor: " +item.getValorPod() + "\n" +
                    "» Marca: " +item.getMarcaProd()+ "\n" +
                    "» Quantidade: " +item.getQuantidadeProdutoCadastrado() + "\n__________________\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    private static void chamaRelatorioServicos() {

        // RELATORIO DE PRODUTOS CADASTRADOS

        List<Servico> servicos = ServicoDAO.buscarTodos();
        StringBuilder lista = new StringBuilder("Lista de Servicos");
        for (Servico item : servicos) {
            lista.append("\n").append(
                    "» Codigo: " +item.getCodigoServicoAleatorio() + "\n" +
                            "» Nome Serviço: " + item.getNomeServico() +"\n"+
                            "» Valor Hora: " +item.getValorHoraTrab() + "\n__________________\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    private static void chamaRelatorioVendas() {

        // RELATORIO DE VENDAS CADASTRADAS

        List<Venda> vendas = VendaDAO.buscarTodos();
        StringBuilder lista = new StringBuilder("Lista de Vendas");
        for (Venda venda : vendas) {
            lista.append("\n").append(
                    "» Codigo Venda: "+venda.getCodVenda() + "\n" +
                    "» Produto/Serviço: "+venda.getDescVenda() + "\n" +
                    "» Quantidade ou Horas: "+venda.getQuantidadeP() + "\n" +
                    "» Forma De Pagamento: " +venda.getFormaPagamento() + "\n" +
                    "» Total Venda: " +(venda.getValorProdutos() * venda.getQuantidadeP() - venda.getDesconto()) + "\n__________________\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    private static void chamaAjuda() {
        JOptionPane.showMessageDialog(null, "❰SGMC❱\n\n" +
                "» Contato: (48) 4002-8922\n" +
                "» Email: sgmc@suportecliente.com\n" +
                "\n" +
                "Vesão: 1.09\n" +
                "Servidor: 192.168.0.100\n");
        chamaMenuPrincipal();
    }

    private static void chamaMenuPrincipal() {

        // MEU PRINCIPAL DO SISTEMA

        String[] opcoesMenu = {"Cadastros", "Relatorios","Ajuda" ,"Sair"};
        int opcao = JOptionPane.showOptionDialog(null, " " +
                        "❰SGMC❱\n\n" +
                        " MENU DE OPÇÕES" ,
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);
        switch (opcao) {
            case 0: //CADASTRO
                chamaMenuCadastros();
                break;
            case 1: //RELATORIO
                chamaMenuRelatorios();
                break;
            case 2: //AJUDA
                chamaAjuda();

                break;
            case 3: //SAIR

                break;
        }
    }

    private static void checaSenhaUsuario(Object usuarioLogado) {

        // FAZ A CHECAGEM DE USUARIO COM SUAS SENHAS

        String senhaDigitada = JOptionPane.showInputDialog(null, " " +
                "❰SGMC❱\n\n» Usuario: " + usuarioLogado + "\nDigite a senha: ");
        Usuario usuarioByLogin = UsuarioDAO.findUsuarioByLogin((String) usuarioLogado);

        assert usuarioByLogin != null;
        if (usuarioByLogin.getSenha().equals(senhaDigitada)) {
            chamaMenuPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, " " +
                    "❰SGMC❱\n\nSenha incorreta!");
            checaSenhaUsuario(usuarioLogado);
        }
    }


    private static Object chamaSelecaoUsuario() {

        // PEDE O USUARIO DESEJADO

        Object[] selectionValues = UsuarioDAO.findUsuariosSistemaInArray();
        String initialSelection = (String) selectionValues[0];
        return JOptionPane.showInputDialog(null, "" +
                        "❰SGMC❱\n\nSelecione seu usuario: ",
                "SGMC", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
    }
}