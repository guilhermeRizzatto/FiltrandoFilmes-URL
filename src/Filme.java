public class Filme {

  private String title;
  private String genrer;

  public Filme(String title, String genrer) {
    this.title = title;
    this.genrer = genrer;
  }

  public String getTitle() {
    return title;
  }

  public String getGenrer() {
    return genrer;
  }

  @Override
  public String toString() {
    return title + "{" + genrer + "}";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + ((genrer == null) ? 0 : genrer.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Filme other = (Filme) obj;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (genrer == null) {
      if (other.genrer != null)
        return false;
    } else if (!genrer.equals(other.genrer))
      return false;
    return true;
  }

}