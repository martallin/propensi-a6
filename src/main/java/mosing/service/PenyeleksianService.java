package mosing.service;

import mosing.model.PenyeleksianModel;

public interface PenyeleksianService {
	void addPenyeleksian(PenyeleksianModel penyeleksian);
	PenyeleksianModel selectPenyeleksian(int id_jalur);
	PenyeleksianModel selectPenyeleksian2(int no_daftar);
	void updateBerkas(String berkas, int no_daftar);
}