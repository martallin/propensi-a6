package mosing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PengawasUjianModel {
	
	private String id_user;
	private boolean status;
	private String jabatan;
	private String nama;
	private String lokasi;
}
