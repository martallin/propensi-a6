package mosing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalonMahasiswaModel {
	private int no_daftar;
	private String npm;
	private int id_prodi;
	private int id_jalur;
	private String jenjang;
}
