package br.cesul.studentregistry.repository;

import br.cesul.studentregistry.model.Student;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Updates.set;

/*
* findAll, save(Student), toggleFlag(id), updateField(id, X), deleteAll()
* */
public class StudentRepository {
    private final MongoCollection<Student> col;

    public StudentRepository(MongoDatabase db, String collectionName) {
        this.col = db.getCollection(collectionName, Student.class);
    }

    public StudentRepository(MongoDatabase db){
        this(db,"students");
    };


    /*
    * deleteAll - apagar todos os documentos da coleção em questão
    * Por que existe? Para que cada teste comece com uma base vazia
    * evitando vazamento de estado de uma base vazia
    * */
    public void deleteAll(){
        // col.drop()
        /*
        * Quando passo o deleteMany com filtro vazio, ele deleta todos os documents da coleção atual;
        * Se eu chamasse o drop, ele derruba a coleção, mas é mais intrusivo;
        * */
        col.deleteMany(new Document());
    }

    public Student save(Student s) {
        col.insertOne(s);
        return s;
    }

    public List<Student> findAll(){
        var list = new ArrayList<Student>();
        // Itera sobre todos os elementos que estou trabalhando e adiciona de um por um a nossa lista
        col.find().into(list);
        return list;
    }

    private Bson byId(String id) {
        return Filters.or(
                Filters.eq("_id", id),
                Filters.eq("id", id)
        );

    }

    public void toggleFlag(String id) {
        var found = col.find(byId(id)).first();
        if (found != null){
            col.updateOne(byId(id), set("active", !found.isActive()));
        }
    }

    public void updateField(String id, double newGrade){
        col.updateOne(byId(id), set("grade", newGrade));
    }
}
