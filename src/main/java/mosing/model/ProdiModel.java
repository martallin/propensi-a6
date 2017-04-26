package mosing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdiModel {
	private int id_prodi;
	private String nama_prodi;
	private int daya_tampung;
	private String nama_fakultas;
	private int id_jalur;
}