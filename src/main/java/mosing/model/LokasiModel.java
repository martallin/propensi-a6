package mosing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LokasiModel {

	private String id_lokasi;
	private String alamat;
	private String no_telp;
	private String nama_lokasi;
	private String provinsi;
	private String kota;
	private int kuota_peng;
	private int kuota_pend;
	
}
