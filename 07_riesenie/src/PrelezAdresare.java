import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

class PrelezAdresare{ 
	public static long prelez(String dir) {
		//System.out.println(dir);
		File fi = new File(dir);
		long suma = 0;
		File[] fs = fi.listFiles();
		for (File f : fs) {
			if (f.isDirectory())
				prelez(f.getAbsolutePath());
			else if (f.getName().lastIndexOf(".java") > 0)
				suma += f.length();
		}
		return suma;
	}

	public static long prelez1(String dir) {
		//System.out.println(dir);
		File fi = new File(dir);
		long suma = 0;
		File[] fs = fi.listFiles(new FilterDirs());
		for (File f : fs) 
			prelez1(f.getAbsolutePath());
		File[] fss = fi.listFiles(new FilterPripony(".java"));
		for (File f : fss) 
			suma += f.length();
		return suma;
	}

	public static void main(String[] args) {
		String koren = "c:\\YUNK";
		System.out.println(prelez(koren));
		System.out.println(prelez1(koren));
	}
}

class FilterDirs implements FileFilter {
	public boolean accept(File pathname) {
		return pathname.isDirectory();
	}
}


class FilterPripony implements FilenameFilter {
	String maska;

	FilterPripony(String maska) {
		this.maska = maska;
	}

	public boolean accept(File dir, String name) {
		if (name.lastIndexOf(maska) > 0)
			return true;
		else
			return false;
	}
}

