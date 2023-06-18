package automoveis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApp {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("automoveis");
        EntityManager em = emf.createEntityManager();

        try {
            // Criação das marcas
            Marca marca1 = new Marca("Volksvagen");
            Marca marca2 = new Marca("Chevrolet");

            // Criação dos modelos
            Modelo modelo1 = new Modelo("Gol", 150, marca1);
            Modelo modelo2 = new Modelo("Celta", 200, marca2);

            // Criação dos automóveis
            Automovel automovel1 = new Automovel(2021, 2022, "Bem conservado", 10000.0f, 5000, modelo1);
            Automovel automovel2 = new Automovel(2020, 2021, "Otimo estado de uso", 15000.0f, 10000, modelo2);

            // Persistência no banco de dados
            em.getTransaction().begin();

            em.persist(marca1);
            em.persist(marca2);

            em.persist(modelo1);
            em.persist(modelo2);

            em.persist(automovel1);
            em.persist(automovel2);

            em.getTransaction().commit();

            System.out.println("Dados persistidos com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
