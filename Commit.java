/**
 * This is an example of the git commit object
 * */
package git_test;

import java.security.Timestamp;
import java.util.List;

public class Commit {
	
	/* GIT OBJECT TYPES -- 1. BLOB 2. TREE 3. COMMIT 4. TAG */
	
	/* ALL THE INFORMATION NEEDED FOR THE HISTORY OF THE PROJECT IS STORED IN A FILE NAMED WITH 40 DIGIT OBJECT NAME
	 * GIT OBJECT IDENTIFICATION : SHA-1 VALUE (20 BYTES LENGTH)
	 * 
	 * 40 HEX DIGITS - FIRST TWO FOR DIRECTORY AND REMAINING FOR THE FILE
	 * 
	 * GIT OBJECTS CAN BE COMPARED BY NAME, IDENTICAL OBJECTS HAVE IDENTICAL NAME
	 * */
	
	/*COMMIT OBJECT:
	 * 1. Commit object points to a single tree, which tells us what project looked like at a certain point in time
	 * 3. contains:
	 * 		SHA-1 of the root tree
	 * 		List of parent commits SHA keys
	 * 			0 parent in case of 1st commit
	 * 			1 parent in case of typical incremental commit
	 * 			2 or more parents merge commit
	 * 		Author and change timestamp
	 * 		Committer and Commit timestamp
	 * 		Commit message
	 * 
	 * Commits manage history with a linked list of commits
	 * SHA-1 name of the commit object is calculated from its commit contents including metadata
	 * */
	
	public static final String OBJECT_TYPE = "COMMIT";
	private String authorName;
	private Timestamp changeTimeStamp;
	private String committerName;
	private Timestamp commitTimeStamp;
	private String commitMessage;
	
	private String rootTreeSHA_1;
	private List<String> parentCommits;
	
	private int hashCode;

	
	
	public Commit(String authorName, Timestamp changeTimeStamp, String committerName, Timestamp commitTimeStamp,
			String commitMessage, List<String> parentCommits) {
		super();
		this.authorName = authorName;
		this.changeTimeStamp = changeTimeStamp;
		this.committerName = committerName;
		this.commitTimeStamp = commitTimeStamp;
		this.commitMessage = commitMessage;
		this.parentCommits = parentCommits;
		
		//after getting all of the above information, we will get hashcode using all of the commit contents and the metadata
		this.hashCode = hashCode();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		result = prime * result + ((changeTimeStamp == null) ? 0 : changeTimeStamp.hashCode());
		result = prime * result + ((commitMessage == null) ? 0 : commitMessage.hashCode());
		result = prime * result + ((commitTimeStamp == null) ? 0 : commitTimeStamp.hashCode());
		result = prime * result + ((committerName == null) ? 0 : committerName.hashCode());
		result = prime * result + ((parentCommits == null) ? 0 : parentCommits.hashCode());
		return result;
	}
	
	//Only getters since its an immutable object.
	public String getAuthorName() {
		return authorName;
	}

	public Timestamp getChangeTimeStamp() {
		return changeTimeStamp;
	}

	public String getCommitterName() {
		return committerName;
	}

	public Timestamp getCommitTimeStamp() {
		return commitTimeStamp;
	}

	public String getCommitMessage() {
		return commitMessage;
	}

	public String getRootTreeSHA_1() {
		return rootTreeSHA_1;
	}

	public List<String> getParentCommits() {
		return parentCommits;
	}
		
	public int getHashCode() {
		return hashCode;
	}

}
