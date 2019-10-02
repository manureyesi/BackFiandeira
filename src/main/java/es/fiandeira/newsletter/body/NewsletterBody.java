package es.fiandeira.newsletter.body;

public class NewsletterBody {

	private String email;

	/**
	 * NewsletterBody
	 * @param email
	 */
	public NewsletterBody(String email) {
		this.email = email;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NewsletterBody [email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	
}
