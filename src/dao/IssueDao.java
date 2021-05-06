package dao;

import java.util.List;

import models.Issue;

public interface IssueDao {
	public Integer addIssue(Issue issue);
	public Integer updateIssue(Issue issue);
	public Integer deleteIssue(Issue issue);
	public Integer getIdByBookandStudent(Integer bookId, Integer studentID);
	public Issue getIssueById(Integer id);
	public List<Issue> getAllIssue();
	public Integer returnBook(Issue issue);

}
