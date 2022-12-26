package ma.enset.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ClientRequestDto {

    public String nom;
    public String adresse;
    public String email;
    public int tel;
}
