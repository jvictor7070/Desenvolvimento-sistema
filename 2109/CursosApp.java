import java.util.Scanner;

public class CursosApp  {

public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Curso curso = null;

        String nomeAluno = null;

        double valorMatricula = 0;

        boolean matriculaRealizada = false;

        while (true) {

            System.out.println("\n===== SISTEMA DE CURSOS =====");
            System.out.println("1 - Cadastrar curso");
            System.out.println("2 - Escolher curso presencial ou online");
            System.out.println("3 - Cadastrar nome do aluno");
            System.out.println("4 - Realizar matrícula");
            System.out.println("5 - Realizar matrícula com desconto");
            System.out.println("6 - Mostrar dados do curso");
            System.out.println("7 - Mostrar dados da matrícula");
            System.out.println("8 - Encerrar programa");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n--- CADASTRO DO CURSO ---");

                    System.out.print("Código: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome do curso: ");
                    String nome = scanner.nextLine();

                    System.out.print("Carga horária: ");
                    int cargaHoraria = scanner.nextInt();

                    System.out.print("Valor: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    
                    curso = new CursoPresencial(
                            codigo,
                            nome,
                            cargaHoraria,
                            valor,
                            "",
                            ""
                    );

                    System.out.println(
                            "Curso cadastrado com sucesso."
                    );

                    System.out.println(
                            "Escolha o tipo do curso na opção 2."
                    );

                    break;

                case 2:

                    if (curso == null) {

                        System.out.println(
                                "Cadastre o curso primeiro."
                        );

                        break;
                    }

                    System.out.println(
                            "\n--- TIPO DE CURSO ---"
                    );

                    System.out.println(
                            "1 - Curso Presencial"
                    );

                    System.out.println(
                            "2 - Curso Online"
                    );

                    System.out.print(
                            "Escolha o tipo: "
                    );

                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    if (tipo == 1) {

                        System.out.print(
                                "Nome da sala: "
                        );

                        String sala =
                                scanner.nextLine();

                        System.out.print(
                                "Turno: "
                        );

                        String turno =
                                scanner.nextLine();

                        curso = new CursoPresencial(
                                curso.getCodigo(),
                                curso.getNome(),
                                curso.getCargaHoraria(),
                                curso.getValor(),
                                sala,
                                turno
                        );

                        System.out.println(
                                "Curso definido como PRESENCIAL."
                        );

                    } else if (tipo == 2) {

                        System.out.print(
                                "Endereço da plataforma: "
                        );

                        String plataforma =
                                scanner.nextLine();

                        System.out.print(
                                "Código de acesso: "
                        );

                        String codigoAcesso =
                                scanner.nextLine();

                        curso = new CursoOnline(
                                curso.getCodigo(),
                                curso.getNome(),
                                curso.getCargaHoraria(),
                                curso.getValor(),
                                plataforma,
                                codigoAcesso
                        );

                        System.out.println(
                                "Curso definido como ONLINE."
                        );

                    } else {

                        System.out.println(
                                "Tipo inválido."
                        );
                    }

                    break;

                case 3:

                    System.out.println(
                            "\n--- CADASTRO DO ALUNO ---"
                    );

                    System.out.print(
                            "Nome do aluno: "
                    );

                    nomeAluno =
                            scanner.nextLine();

                    System.out.println(
                            "Aluno cadastrado com sucesso."
                    );

                    break;

                case 4:

                    if (curso == null) {

                        System.out.println(
                                "Cadastre o curso primeiro."
                        );

                    } else if (nomeAluno == null
                            || nomeAluno.isEmpty()) {

                        System.out.println(
                                "Cadastre o nome do aluno primeiro."
                        );

                    } else {

                        valorMatricula =
                                curso.realizarMatricula();

                        matriculaRealizada = true;

                        System.out.printf(
                                "Matrícula realizada com sucesso!%n"
                        );

                        System.out.printf(
                                "Valor da matrícula: R$ %.2f%n",
                                valorMatricula
                        );
                    }

                    break;

                case 5:

                    if (curso == null) {

                        System.out.println(
                                "Cadastre o curso primeiro."
                        );

                    } else if (nomeAluno == null
                            || nomeAluno.isEmpty()) {

                        System.out.println(
                                "Cadastre o nome do aluno primeiro."
                        );

                    } else {

                        System.out.print(
                                "Informe o valor do desconto: R$ "
                        );

                        double desconto =
                                scanner.nextDouble();

                        valorMatricula =
                                curso.realizarMatricula(
                                        desconto
                                );

                        matriculaRealizada = true;

                        System.out.printf(
                                "Matrícula realizada com desconto!%n"
                        );

                        System.out.printf(
                                "Valor final: R$ %.2f%n",
                                valorMatricula
                        );
                    }

                    break;

                case 6:

                    if (curso == null) {

                        System.out.println(
                                "Nenhum curso cadastrado."
                        );

                    } else {

                        System.out.println(
                                "\n--- DADOS DO CURSO ---"
                        );

                        curso.mostrarDados();
                    }

                    break;

                case 7:

                    if (!matriculaRealizada) {

                        System.out.println(
                                "Nenhuma matrícula foi realizada."
                        );

                    } else {

                        System.out.println(
                                "\n--- DADOS DA MATRÍCULA ---"
                        );

                        System.out.println(
                                "Aluno: " + nomeAluno
                        );

                        System.out.println(
                                "Curso: " + curso.getNome()
                        );

                        System.out.println(
                                "Código do curso: "
                                        + curso.getCodigo()
                        );

                        System.out.printf(
                                "Valor da matrícula: R$ %.2f%n",
                                valorMatricula
                        );
                    }

                    break;

                case 8:

                    System.out.println(
                            "Programa encerrado."
                    );

                    scanner.close();
                    return;

                default:

                    System.out.println(
                            "Opção inválida."
                    );
            }
        }
    }
}
