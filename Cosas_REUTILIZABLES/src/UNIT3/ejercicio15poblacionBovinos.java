package UNIT3;
public class ejercicio15poblacionBovinos {

	public static void main(String[] args) {
		double CP = 354000, BP = 410000, year= 0;
		double tasaCaaceres= 1.0101, tasaBadajoz= 0.9985;
		boolean jk = true;
		do {
			if(CP> BP) {
				jk = false;
			}
			System.out.printf("Año %.0f \n", year);
			System.out.printf("Población en Cáceres: %.0f        Población en Badajoz: %.0f \n", CP , BP);
			CP = CP* tasaCaaceres; // 100% + 1,01%= 101,01% ; (no lo queremos en porcentaje) 101,01/100= 1.0101;
			BP = BP *  tasaBadajoz ; // para la reducción= 100% - 0.15%= 99.85% ; (no lo queremos en porcentaje) 99,85/100=  0.9985;
			
			year++;
		}while (jk == true);

	}

}


