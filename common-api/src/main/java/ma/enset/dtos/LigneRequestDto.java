package ma.enset.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class LigneRequestDto {
    private String id;
    private double quantite;
    private double prixUnit;
    private double remise;
}
