
class SolutionA {
  public int strStr(final String haystack, final String needle)
  {
    if (haystack == null || needle == null)
      return -1;

    final int nlen = needle.length();
    final int hlen = haystack.length();
    if (nlen > hlen)
      return -1;

    int needleHash = 0;
    int hash_remove = 1;
    for (char c: needle.toCharArray()) {
      needleHash = addHash(needleHash, c);
      hash_remove = addHash(hash_remove, '\0');
    }

    int haystackHash = 0;
    for (int i = 0;  i < nlen - 1;  ++i) {
      haystackHash = addHash(haystackHash, haystack.charAt(i));
    }

    for (int i = 0;  i + nlen < hlen;  ++i) {
      haystackHash = addHash(haystackHash, haystack.charAt(i + nlen));
      if (haystackHash == needleHash && haystack.substring(i, i+nlen) == needle)
        return i;
      haystackHash -= haystack.charAt(i) * hash_remove;
    }

    return -1;
  }

  private int addHash(int h, char c)
  {
    // calculation may overflow, but that's fine
    return 31 * h + c;
  }
}
