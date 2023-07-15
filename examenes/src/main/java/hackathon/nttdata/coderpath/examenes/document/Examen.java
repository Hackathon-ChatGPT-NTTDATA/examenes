package hackathon.nttdata.coderpath.examenes.document;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


@Generated
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "examenes")
public class Examen {
	
	 
	@Id
	private String id;
	private String nombre;
	private String nota;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	
	
	
	

}
