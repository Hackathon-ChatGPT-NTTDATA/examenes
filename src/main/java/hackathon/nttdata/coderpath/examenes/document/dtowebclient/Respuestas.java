package hackathon.nttdata.coderpath.examenes.document.dtowebclient;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respuestas {
	
	private String id;
	
	private String texto;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	

}
