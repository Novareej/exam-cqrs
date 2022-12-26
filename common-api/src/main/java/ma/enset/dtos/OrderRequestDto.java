package ma.enset.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderRequestDto {
    private String id;
    private Date date_cmd;
    private Date date_livr;
    private String add_livr;
    private String statut;
}
