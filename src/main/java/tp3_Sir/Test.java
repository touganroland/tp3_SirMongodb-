package tp3_Sir;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public abstract class Test {

	public static void main( String[] args ) throws UnknownHostException
	{
		Morphia morphia = new Morphia();	
		MongoClient mongo = new MongoClient();
		morphia.map(Person.class).map(Address.class);
		Datastore ds = morphia.createDatastore(mongo, "my_database");
		
		
		Person personne1 = new Person();
		personne1.setName("Tougan");
		ds.save(personne1);
		
		
		Person personne2 = new Person();
		personne2.setName("Kiko");
		ds.save(personne2);
		
		Person personne3 = new Person();
		personne3.setName("Soumahoro");
		ds.save(personne3);
		
		List<Person> listesdespersonnes = new ArrayList<Person>();
		listesdespersonnes.add(personne1);
		listesdespersonnes.add(personne2);
		listesdespersonnes.add(personne3);
		ds.save(listesdespersonnes);
		
		Article article1 = new Article();
		article1.setName("Iphone");
		article1.setStars(1);
		ds.save(article1);
		
		Article article2 = new Article();
		article2.setName("Samsung");
		article2.setStars(2);
		ds.save(article2);
		
		Article article3 = new Article();
		article3.setName("Wiko");
		article3.setStars(3);
		ds.save(article3);
		
		List<Article> listesdesarticles = new ArrayList<Article>();
		listesdesarticles.add(article1);
		listesdesarticles.add(article2);
		listesdesarticles.add(article3);
		ds.save(listesdesarticles);
		
		
		
		Address adresse1 = new Address();
		adresse1.setCity("rennes");
		adresse1.setCountry("france");
		adresse1.setPostCode("35700");
		adresse1.setStreet("1 ter rue du houx");
		ds.save(adresse1);
		
		Address adresse2 = new Address();
		adresse2.setCity("Paris");
		adresse2.setCountry("france");
		adresse2.setPostCode("75001");
		adresse2.setStreet("1 rue de sébastopol");
		ds.save(adresse2);
		
		Address adresse3 = new Address();
		adresse3.setCity("Lyon");
		adresse3.setCountry("france");
		adresse3.setPostCode("69001");
		adresse3.setStreet("1 Place de la Comédie");
		//ds.save(adresse3);
		
		List<Address> listesdesadresses = new ArrayList<Address>();
		listesdesadresses.add(adresse1);
		listesdesadresses.add(adresse2);
		listesdesadresses.add(adresse3);
		ds.save(listesdesadresses);
		
		
		System.out.println("les personnes");
		for (Person per : ds.find(Person.class)) {
			System.err.println(per.getName());
		}
			

		System.out.println("les adresses");
		for (Address add : ds.find(Address.class)) {
			System.err.println(add.getStreet());
		}
		
		

		System.out.println("les articles");
		for (Article art : ds.find(Article.class)) {
			System.err.println(art.getName());
		}
	

	}
}
