import java.io.*;

public class GrowingArrayOfActividade {

    // Variáveis de instância
    private Actividade[] lista;
    private int Tamanho;

    public GrowingArrayOfActividade() {
        this.Tamanho = 0;
        this.lista = new Actividade[16];
    }

    public GrowingArrayOfActividade(Actividade[] lista, int Tamanho) {
        this.Tamanho = Tamanho;
        this.lista = new Actividade[Tamanho];
    }

    public Actividade get(int indice) {

        if(indice > this.lista.length || indice < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return this.lista[indice];
    }


    public void add(Actividade a) {

        Actividade[] novaLista = new Actividade[++(this.Tamanho)];
        System.arraycopy(this.lista, 0, novaLista, 0, this.Tamanho-1);
        novaLista[this.Tamanho-1] = a;
        this.lista = novaLista;

    }

    public static GrowingArrayOfActividade leGrowingArrayOfActividade(String fich)
            throws IOException, ClassNotFoundException {

        try (FileInputStream fileInputStream = new FileInputStream(fich);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Object object = objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();

            if(object instanceof GrowingArrayOfActividade) {
                return (GrowingArrayOfActividade) object;
            }

            else {
                throw new IOException("Ficheiro não contém um objeto GrowingArrayOfActividade válido...");
            }

        }
    }

    public void guardaGrowingArrayOfActividade(String fich)
        throws IOException, ClassNotFoundException {

        try {
            FileOutputStream fos = new FileOutputStream(fich);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fos.flush();
            fos.close();
        }

        catch (IOException io){
            System.out.println("Erro ao guardar...");
            io.printStackTrace();
        }

    }

}
