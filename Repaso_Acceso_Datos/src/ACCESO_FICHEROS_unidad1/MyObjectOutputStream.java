package ACCESO_FICHEROS_unidad1;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {
		public MyObjectOutputStream(OutputStream out) throws IOException {
			super(out);
		}

		protected MyObjectOutputStream() throws IOException, SecurityException {
			super();
		}

		@Override
		protected void writeStreamHeader() throws IOException {

		}
}
