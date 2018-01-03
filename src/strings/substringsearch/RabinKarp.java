package strings.substringsearch;

public class RabinKarp {
	private String pat;
	private long patHash;
	private int M;
	private long Q;
	private int R = 256;
	private long RM;

	public RabinKarp(String pat) {
		this.pat = pat;
		this.M = pat.length();
		//Q = longRandomPrime(); // See Exercise 5.3.33
		RM = 1;
		for (int i = 1; i <= M-1; i++) {
			RM = (R * RM) % Q;
		}
		patHash = hash(pat, M);
	}

	public boolean check(int i) {
		return true;
	}
	
	public long hash(String key, int M) {
		long h = 0;
		for (int j= 0; j < M; j++) {
			h = (R * h + key.charAt(j)) % Q;
		}
		return h;
	}

	public int search(String txt) {
		int N = txt.length();
		long txtHash = hash(txt, M);
		if (txtHash == patHash) {
			return 0;
		}
		for (int i = M; i < N; i++) {
			txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
			txtHash = (txtHash * R + txt.charAt(i)) % Q;

			if (txtHash == patHash) {
				if (check(i - M + 1)) {
					return i - M + 1;
				}
			}
		}

		return N;
	}
}
