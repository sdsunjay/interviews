/*
We are building a CLI to find all the files in a given directory
that match some search criteria. How would you implement the
backend method search for files whose filenames equal a given string?

Ex. command line
findFiles -root /path/to/dir -equals value -fileSizeLessThan 5000 -creationDateAfter 04/2018 ...

class FSObject  {
	String name;
	int fileSize;
	List<FSObject> children;
}

You can assume there is some preprocessing happening to parse the CLI options
and call your method with the root FSObject and any parameters you think are relevant
*/


//return list of FSObject
public List<FSObject> bfs(FSObject root, String name, Criteria criteria){
    List<FSObject> result = new ArrayList<FSObject>();
    Queue queue = new queue<FSObject>();
    queue.add(root);
    FSObject temp;
    while(!queue.isEmpty()){
        temp = queue.remove()
        if(checkCriteria(temp, criteria)){
         result.add(temp);
        }
        for(int i = 0; i < temp.children.size(); i++){
            queue.add(temp.children.get(i));
        }
    }
    return result;
}
private boolean checkCriteria(FSObject temp, Criteria criteria){
    Criteria.checkCriteria(temp);
}
class Criteria {
    List<Restriction> restriction = new ArrayList<Restriction>();
    // some property
    public booleancheckCriteria(temp){
        //iterate through each restriction and see if temp meets it
    }
}
