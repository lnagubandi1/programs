import java.util.*;
import java.util.stream.Collectors;

public class ManyToMany {

    public static void main(String args[])
    {
//        List<Signer> signers1 = new ArrayList<>();
//        List<Signer> signers2 = new ArrayList<>();
//
//        List<Document> documents1 = new ArrayList<>();
//        List<Document> documents2 = new ArrayList<>();
//
//        signers1.add(new Signer("signerId1", documents1));
//        signers2.add(new Signer("signerId2", documents2));
//
//        documents1.add(new Document("doc1",signers1));
//        documents2.add(new Document("doc2",signers2));
//
//
//        Document document1 = new Document("Document1", signers1);
//        Document document2 = new Document("Document2", signers2);
//
//        Signer signer1 = new Signer("Signer1", documents1);
//        Signer signer2 = new Signer("Signer2", documents2);

        Signer signer1 = null, signer2 = null, signer3 = null;


        Document document1 = new Document("Document1", Arrays.asList(signer1, signer3));
        Document document2 = new Document("Document2", Arrays.asList(signer1, signer2));
        Document document3 = new Document("Document3", Arrays.asList(signer2, signer3));

        signer1 = new Signer("Signer1", Arrays.asList(document1, document2));
        signer2 = new Signer("Signer2", Arrays.asList(document2, document3));
        signer3 = new Signer("Signer3", Arrays.asList(document1, document3));

        List<Document> documents = Arrays.asList(document1, document2, document3);
        List<Signer> signers = Arrays.asList(signer1, signer2, signer3);

//        Map<String,List<Document>> map =documents.stream().flatMap(document->document.getSigners()
//                .stream())
//                .collect(Collectors.groupingBy(Signer::getSignerId, LinkedHashMap::new,  Collectors.toList()));

        Map<String, List<Signer>> groupedBySigner = documents.stream()
                .flatMap(document -> document.getSigners().stream())
                .collect(Collectors.groupingBy(Signer::getSignerId, Collectors.toList()));

        List<Signer> signerList = groupedBySigner.entrySet().stream()
                .map(entry -> {
                    List<Document> associatedDocuments = entry.getValue().stream()
                            .flatMap(signer -> signer.getDocuments().stream())
                            .collect(Collectors.toList());
                    return new Signer(entry.getKey(), associatedDocuments);
                })
                .collect(Collectors.toList());
        System.out.println(signerList);






        BlogPost post1 = new BlogPost("babubali","rajmouli",BlogPostType.REVIEW,300);
        BlogPost post2 = new BlogPost("babubali2","rajmouli",BlogPostType.REVIEW,300);
        BlogPost post3 = new BlogPost("babubali3","rajmouli",BlogPostType.REVIEW,100);
        BlogPost post4 = new BlogPost("babubali4","rajmouli",BlogPostType.REVIEW,0);


        List<BlogPost> posts = Arrays.asList(post1,post2,post3,post4);

        Map<Tuple,List<BlogPost>> map = posts.stream().collect(Collectors.groupingBy(post->new Tuple(post.getType(),post.getAuthor())));

        //multiple grouping bys

       Map<String,Map<BlogPostType,List<BlogPost>>>  map3 = posts.stream().collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.groupingBy(BlogPost::getType)));

       //Getting avg from Grouped results

        Map<BlogPostType, Double> map4 = posts.stream().collect(Collectors.groupingBy(post->post.getType(), Collectors.averagingInt(BlogPost::getLikes)));

        //Getting max or min from the groupped results
        //very imp see the value you get the min BlogPost object not directly the int value of min like
        Map<BlogPostType, Optional<BlogPost>> map5 = posts.stream().collect(Collectors.groupingBy(BlogPost::getType,Collectors.minBy(Comparator.comparingInt(BlogPost::getLikes)) ));


    }
}
