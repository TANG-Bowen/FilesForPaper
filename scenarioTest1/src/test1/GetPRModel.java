package test1;

import org.jtool.prmodel.PRModelBundle;
import org.jtool.prmodel.PRModel;
import org.jtool.prmodel.PullRequest;
import java.util.Set;

public class GetPRModel {
    
    private final static String GITHUB_TOKEN = "";
    private final static String ROOT_SOURCE_PATH = "/Users/tangbowen/PRDataset-sce";
    private final static String REPOSITORY_NAME = "spring-projects/spring-boot";
    
    GetPRModel() {
    }
    
    public static void main(String[] args) {
        GetPRModel getPRModel = new GetPRModel();
        Set<PullRequest> pullRequests = getPRModel.getPRs(GITHUB_TOKEN, REPOSITORY_NAME, ROOT_SOURCE_PATH);
        pullRequests.forEach(pr -> pr.print());
    }
    
    public Set<PullRequest> getPRs(String ghToken, String repositoryName, String rootSrcPath) {
        PRModelBundle bundle = new PRModelBundle(ghToken, repositoryName, rootSrcPath);
        
        bundle.searchByIsClosed();
        bundle.searchByCreated("2024-04-01", "2024-04-03");
        
        PRModel prmodel = bundle.build();
        return prmodel.getPullRequests();
    }
}
