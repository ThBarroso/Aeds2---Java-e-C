import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Scanner;

class Personagem{
    private String id;
    private String nome;
    private String nome_alternativo;
    private String casa;
    private String ancestral;
    private String especie;
    private String patronus;
    private Boolean staff;
    private String estudante;
    private String nomeator;
    private Boolean vivo;
    private String atoresalternativos;
    private Date dianascimento;
    private int anonascimento;
    private String corolho;
    private String sexo;
    private String corcabelo;
    private Boolean bruxo;

    public Personagem(){
        //nome_alternativo = new ArrayList<>();
        this.staff = false;
        this.vivo=false;
        this.bruxo=false;
    }
    public Personagem(String id2, String nome2, String nomeAlternativo, String casa2, String ancestral2,
            String especie2, String patronus2, Boolean staff2, String estudante2, String nomeator2, Boolean vivo2,
            String atorAlternativo, Date dianascimento2, int anonascimento2, String corolho2, String sexo2,
            String corcabelo2, Boolean bruxo2) {
                setId(id2);
                setNome(nome2);
                setCasa(casa2);
                setNomeAlternativo(nomeAlternativo);
                setAncestral(ancestral2);
                setEspecie(especie2);
                setPatronus(patronus2); 
                setStaff(staff2);
                setEstudante(estudante2);
                setNomeator(nomeator2);
                setVivo(vivo2);
                setDatedianascimento(dianascimento2);
                setAtorAlternativo(atorAlternativo);
                setAnonascimento(anonascimento2);
                setCorolho(corolho2);
                setSexo(sexo2);
                setCorcabelo(corcabelo2);
                setBruxo(bruxo2);
    }
    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public void setNomeAlternativo(String nomeAlternativo) {
        //this.nome_alternativo = new ArrayList<>(nomeAlternativo);
        this.nome_alternativo=nomeAlternativo;
    }

   // public void addNomeAlternativo(String nomeAlternativo) {
      //  this.nome_alternativo.add(nomeAlternativo);
  //  }

    public void setAncestral(String ancestral) {
        this.ancestral = ancestral;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
    }

    public void setEstudante(String estudante) {
        this.estudante = estudante;
    }

    public void setNomeator(String nomeator) {
        this.nomeator = nomeator;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
    public void setAtorAlternativo(String dados){
            dados = dados.replace("[", "").replace("]", "").replace("'", "").trim();
            if (!dados.isEmpty()) {
                String[] nomes = dados.split(", ");
                for (String nome : nomes) {
                    this.nome_alternativo=nome;
                }
            }
    }

    public void setDianascimento(String dianascimentoStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.dianascimento = sdf.parse(dianascimentoStr);
        } catch (Exception e) {
            System.out.println("Formato de data inválido: " + e.getMessage());
            this.dianascimento = null; 
        }
    }
    public void setDatedianascimento(Date dianascimento){
        this.dianascimento=dianascimento;
    }

    public void setAnonascimento(int anonascimento) {
        this.anonascimento = anonascimento;
    }

    public void setCorolho(String corolho) {
        this.corolho = corolho;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCorcabelo(String corcabelo) {
        this.corcabelo = corcabelo;
    }

    public void setBruxo(boolean bruxo) {
        this.bruxo = bruxo;
    }
// Getters
        public String getId() {
            return id;
        }
    
        public String getNome() {
            return nome;
        }
    
        public String getCasa() {
            return casa;
        }
    
        public String getNomeAlternativo() {
            return nome_alternativo;
        }
    
        public String getAncestral() {
            return ancestral;
        }
    
        public String getEspecie() {
            return especie;
        }
    
        public String getPatronus() {
            return patronus;
        }
    
        public boolean isStaff() {
            return staff;
        }
    
        public String isEstudante() {
            return estudante;
        }
    
        public String getNomeator() {
            return nomeator;
        }
    
        public boolean isVivo() {
            return vivo;
        }
        public String getatoralternativo(){
            return atoresalternativos;
        }
    
        public String getDianascimento() {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            if (this.dianascimento != null) {
                return sdf.format(this.dianascimento);
            } else {
                return "Data de nascimento não disponível";
            }
            }
    
        public int getAnonascimento() {
            return anonascimento;
        }
    
        public String getCorolho() {
            return corolho;
        }
    
        public String getSexo() {
            return sexo;
        }
    
        public String getCorcabelo() {
            return corcabelo;
        }
    
        public boolean isBruxo() {
            return bruxo;
        }
    

        public static ArrayList<Personagem> ler(){
            ArrayList<Personagem> lista_de_personagens = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date dianascimentoData;
            HashSet<String> codigos = new HashSet<>();
            Scanner sc = new Scanner(System.in);
            String codigo;
          //  System.out.println("entrou metodo ler");
          while (!(codigo = sc.nextLine().trim()).equals("FIM")) {
            codigos.add(codigo);
        }

            try (BufferedReader br = new BufferedReader(new FileReader("/tmp/characters.csv"))) {
                String linha;
                String[] campos;
                while ((linha = br.readLine()) != null) {
                    campos = linha.split(";");
                    if (codigos.contains(campos[0])) {
                        String Id=campos[0];
                        String Nome=campos[1];
                        String NomeAlternativo=campos[2];
                        String Casa=campos[3];
                        String Ancestral=campos[4];
                        String Especie=campos[5];
                        String Patronus=campos[6];
                        Boolean Staff= campos[7].trim().equalsIgnoreCase("VERDADEIRO");
                        String Estudante=campos[8];
                        String Nomeator=campos[9];
                        Boolean Vivo= campos[10].trim().equalsIgnoreCase("VERDADEIRO");
                        String AtorAlternativo=campos[11];
                        Date Dianascimento=new Date();
                        try{
                            dianascimentoData= sdf.parse(campos[12]);
                            Dianascimento=dianascimentoData;
                        }catch(ParseException e) {
                            e.printStackTrace();
                          }
                        int Anonascimento= Integer.parseInt(campos[13]);
                        String Corolho=campos[14];
                        String Sexo=campos[15];
                        String Corcabelo=campos[16];
                        Boolean Bruxo = campos[17].trim().equalsIgnoreCase("VERDADEIRO");
                        lista_de_personagens.add(new Personagem(Id,Nome,NomeAlternativo,Casa,Ancestral,Especie,Patronus,Staff,Estudante,Nomeator,Vivo,AtorAlternativo,Dianascimento,Anonascimento,Corolho,Sexo,Corcabelo,Bruxo));
                    }
                }
            }catch (IOException e) {
                System.out.println("Erro ao ler arquivo: " + e.getMessage());
            }
            return  lista_de_personagens;
        }
}






public class QuickParcial {
    public static void main(String[] args) {
        ArrayList<Personagem> personagens = Personagem.ler();
        quickSort(0, personagens.size() - 1, personagens);

       for (int i = 0; i < Math.min(10, personagens.size()); i++){
            Personagem personagem = personagens.get(i);
            System.out.println( "["+personagem.getId()+" ## "+personagem.getNome()+" ## "+personagem.getNomeAlternativo()+" ## "+personagem.getCasa()+
            " ## "+personagem.getAncestral()+" ## "+personagem.getEspecie()+" ## "+personagem.getPatronus()+" ## "+personagem.isStaff()+" ## "+personagem.isEstudante()+
            " ## "+personagem.getNomeator()+" ## "+personagem.isVivo()+" ## "+personagem.getDianascimento()+" ## "+personagem.getAnonascimento()+" ## "+personagem.getCorolho()+
            " ## "+personagem.getSexo()+" ## "+personagem.getCorcabelo()+" ## "+personagem.isBruxo()+"]");
        }
    }

    private static void quickSort(int esq, int dir, ArrayList<Personagem> personagens) {
        int i = esq, j = dir;
        Personagem pivo = personagens.get((esq + dir) / 2);

        while (i <= j) {
            // Comparar primeiro por casa, se igual, comparar por nome
            while (compare(personagens.get(i), pivo) < 0) {
                i++;
            }
            while (compare(personagens.get(j), pivo) > 0) {
                j--;
            }
            if (i <= j) {
                swap(personagens, i, j);
                i++;
                j--;
            }
        }

        if (esq < j) {
            quickSort(esq, j, personagens);
        }
        if (i < dir) {
            quickSort(i, dir, personagens);
        }
    }

    private static void swap(ArrayList<Personagem> personagens, int i, int j) {
        Personagem temp = personagens.get(i);
        personagens.set(i, personagens.get(j));
        personagens.set(j, temp);
    }

    // Método para comparar personagens primeiro por casa e depois por nome
    private static int compare(Personagem a, Personagem b) {
        int casaComparison = a.getCasa().compareTo(b.getCasa());
        if (casaComparison != 0) {
            return casaComparison;
        }
        return a.getNome().compareTo(b.getNome());
    }
}