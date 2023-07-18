package hackathon.nttdata.coderpath.examenes.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "examen")
public class Examen {
	
	@Id
	private String id;

	private String nombre;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;

}
