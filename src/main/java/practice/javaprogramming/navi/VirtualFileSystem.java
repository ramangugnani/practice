package practice.javaprogramming.navi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VirtualFileSystem {

    private Integer blockSize = 512;

    private Queue<Integer> availableBlocks;

    private Map<String, FileMetadata> avaialbleFiles;

    private Map<String, FileOpenMetadata> fileOpenPointers;

    private Integer totalBlocks = 100;

    private String[] memoryBlocks;

    public VirtualFileSystem() {
        this.availableBlocks = new LinkedList<>();
        this.avaialbleFiles = new HashMap<String, FileMetadata>();
        this.fileOpenPointers = new HashMap<>();
        // Intially all the blocks are avaialble
        for (Integer i = 0; i < totalBlocks; i++) {
            availableBlocks.add(i);
        }
        memoryBlocks = new String[totalBlocks];
    }

    // fopen input will be fileName
    // we need to take inut of user id as wee for permissions
    // this should open a file and return a pointer to that file
    // TODO we need to handle this
    public String fOpen(Integer userId, String fileName, FileOperation fileOperation) throws OpernationNotAllowed {
        switch (fileOperation) {
        case READ:
            // file needs to exists in our system
            // else throw exception
            if (avaialbleFiles.containsKey(fileName)) {
                FileMetadata fileMetadata = avaialbleFiles.get(fileName);
                if (fileMetadata.getReadAllowedUser().contains(userId)) {
                    // create new file pointer
                    FileOpenMetadata fileOpenMetadata = new FileOpenMetadata();
                    String referenceId = Long.toString(System.currentTimeMillis());
                    fileOpenMetadata.setFileReference(referenceId);
                    // assumed the file is opended from the 1st file block
                    fileOpenMetadata.setBlockIndex(fileMetadata.getMemoryBlocks().get(0));
                    fileOpenMetadata.setBlockLocation(0);
                    fileOpenMetadata.setFileOperation(fileOperation);
                    fileOpenMetadata.setUserId(userId);
                    fileOpenPointers.put(referenceId, fileOpenMetadata);

                    return referenceId;
                } else {
                    // throw exception
                    throw new OpernationNotAllowed("User not allowed");
                }
            } else {
                throw new OpernationNotAllowed("file is not present");
            }
        case WRITE:
            // if the file does not exists we need to create the file
            // else open the file and return the same
            if (avaialbleFiles.containsKey(fileName)) {
                FileMetadata fileMetadata = avaialbleFiles.get(fileName);
                if (fileMetadata.getWriteAllowedUser().contains(userId)) {
                    // create new file pointer
                    FileOpenMetadata fileOpenMetadata = new FileOpenMetadata();
                    String referenceId = Long.toString(System.currentTimeMillis());
                    fileOpenMetadata.setFileReference(referenceId);
                    // assumed the file is opended from the 1st file block
                    fileOpenMetadata.setBlockIndex(fileMetadata.getMemoryBlocks().get(0));
                    fileOpenMetadata.setBlockLocation(0);
                    fileOpenMetadata.setFileOperation(fileOperation);
                    fileOpenMetadata.setUserId(userId);
                    fileOpenPointers.put(referenceId, fileOpenMetadata);
                    return referenceId;
                } else {
                    // throw exception
                    throw new OpernationNotAllowed("User not allowed");
                }
            } else {
                if (availableBlocks.size() > 0) {
                    FileMetadata fileMetadataNew = new FileMetadata();
                    fileMetadataNew.setFileName(fileName);
                    fileMetadataNew.setFileSize(0);
                    Integer availableBlockIndex = availableBlocks.poll();
                    List<Integer> availableBlocksList = new ArrayList<>();
                    availableBlocksList.add(availableBlockIndex);
                    fileMetadataNew.setMemoryBlocks(availableBlocksList);
                    fileMetadataNew.getReadAllowedUser().add(userId);
                    fileMetadataNew.getWriteAllowedUser().add(userId);
                    avaialbleFiles.put(fileName, fileMetadataNew);
                    // create new file pointer
                    FileOpenMetadata fileOpenMetadata = new FileOpenMetadata();
                    String referenceId = Long.toString(System.currentTimeMillis());
                    fileOpenMetadata.setFileReference(referenceId);
                    // assumed the file is opended from the 1st file block
                    fileOpenMetadata.setFileName(fileName);
                    fileOpenMetadata.setBlockIndex(availableBlockIndex);
                    fileOpenMetadata.setBlockLocation(0);
                    fileOpenMetadata.setFileOperation(fileOperation);
                    fileOpenMetadata.setUserId(userId);
                    fileOpenPointers.put(referenceId, fileOpenMetadata);
                    // System.out.println(avaialbleFiles);
                    // System.out.println(fileOpenPointers);
                    return referenceId;
                } else {
                    throw new OpernationNotAllowed("No avaialbale blocks");
                }
            }
        case BOTH:
            // if file exists open the same else create new file
            if (avaialbleFiles.containsKey(fileName)) {
                FileMetadata fileMetadata = avaialbleFiles.get(fileName);
                if (fileMetadata.getWriteAllowedUser().contains(userId)
                        && fileMetadata.getReadAllowedUser().contains(userId)) {
                    // create new file pointer
                    FileOpenMetadata fileOpenMetadata = new FileOpenMetadata();
                    String referenceId = Long.toString(System.currentTimeMillis());
                    fileOpenMetadata.setFileReference(referenceId);
                    // assumed the file is opended from the 1st file block
                    fileOpenMetadata.setBlockIndex(fileMetadata.getMemoryBlocks().get(0));
                    fileOpenMetadata.setBlockLocation(0);
                    fileOpenMetadata.setFileOperation(fileOperation);
                    fileOpenMetadata.setUserId(userId);
                    fileOpenPointers.put(referenceId, fileOpenMetadata);
                    return referenceId;
                } else {
                    // throw exception
                    throw new OpernationNotAllowed("User not allowed");
                }
            } else {
                throw new OpernationNotAllowed("file is not present");
            }
        }
        return null;
    }

    // read
    // should return the character for the file pointer
    public Character fRead(String referenceId) throws OpernationNotAllowed {
        if (fileOpenPointers.containsKey(referenceId)) {
            FileOpenMetadata fileOpenMetadata = fileOpenPointers.get(referenceId);
            // now we need to read a character from the location and return if supported
            Integer blockIndex = fileOpenMetadata.getBlockIndex();
            Integer blockLocation = fileOpenMetadata.getBlockLocation();
            if (blockLocation < blockSize) {
                //System.out.println(blockLocation + "-->" + memoryBlocks[blockIndex]);
                Character myChar = memoryBlocks[blockIndex].charAt(blockLocation);
                blockLocation++;
                if (blockIndex == blockSize) {
                    FileMetadata fileMetadata = avaialbleFiles.get(fileOpenMetadata.getFileName());
                    Integer index = fileMetadata.getMemoryBlocks().indexOf(blockLocation);
                    // TODO if blockLocationhas reached EOF
                    fileOpenMetadata.setBlockLocation(fileMetadata.getMemoryBlocks().get(index + 1));
                    fileOpenMetadata.setBlockIndex(0);
                } else {
                    fileOpenMetadata.setBlockLocation(blockLocation);
                }
                return myChar;
            }
        } else {
            throw new OpernationNotAllowed("Illelag reference Id");
        }
        return null;
    }

    // fwrite
    // should append the character
    // input will be file reference
    public void fWrite(String referenceId, Character myChar) throws OpernationNotAllowed {
        if (fileOpenPointers.containsKey(referenceId)) {
            FileOpenMetadata fileOpenMetadata = fileOpenPointers.get(referenceId);
            FileMetadata fileMetadata = avaialbleFiles.get(fileOpenMetadata.getFileName());
            Integer blockIndex = fileOpenMetadata.getBlockIndex();
            Integer blockLocation = fileOpenMetadata.getBlockLocation();
            Integer fileSize = fileMetadata.getFileSize();
            // if location is in the end , simply append the data

            // if location is of starting or in the middle
            // if that block is not full we need to append the data in the same block
            // if that block is full then we can split the current block into two blocks
            if (null == memoryBlocks[blockLocation] || memoryBlocks[blockLocation].length() < blockSize) {
                if (null == memoryBlocks[blockLocation]) {
                    memoryBlocks[blockLocation] = "" + myChar;

                } else {
                    if (blockIndex == memoryBlocks[blockLocation].length()) {
                        memoryBlocks[blockLocation] = memoryBlocks[blockLocation] + myChar;
                    } else {
                        // append the character in the same block
                        String lastData = memoryBlocks[blockLocation].substring(blockIndex + 1,
                                memoryBlocks[blockLocation].length() - 1);
                        memoryBlocks[blockLocation] = memoryBlocks[blockLocation] + myChar + lastData;
                    }
                }
                fileOpenMetadata.setBlockIndex(blockIndex + 1);
                fileMetadata.setFileSize(fileSize + 1);
            } else {
                // need to get another block
                if (availableBlocks.size() > 0) {
                    Integer availableBlockIndex = availableBlocks.poll();
                    String lastData = memoryBlocks[blockLocation].substring(blockIndex + 1,
                            memoryBlocks[blockLocation].length() - 1);
                    memoryBlocks[blockLocation] = memoryBlocks[blockLocation] + myChar;
                    memoryBlocks[availableBlockIndex] = lastData;
                    // TODO need to handle one edge case
                    fileOpenMetadata.setBlockIndex(blockIndex + 1);
                    fileMetadata.setFileSize(fileSize + 1);
                    // we need to add available block in the list also
                    List<Integer> memoryBlocks = fileMetadata.getMemoryBlocks();
                    Integer currentIndex = memoryBlocks.indexOf(blockLocation);

                    memoryBlocks.add(currentIndex + 1, availableBlockIndex);
                } else {
                    throw new OpernationNotAllowed("No space left");
                }

            }
        } else {
            throw new OpernationNotAllowed("Illelag reference Id");

        }
    }

    // fclose
    // should close the file and remove the file reference
    public void fClose(String referenceId) throws OpernationNotAllowed {
        if (fileOpenPointers.containsKey(referenceId)) {
            fileOpenPointers.remove(referenceId);
        } else {
            throw new OpernationNotAllowed("Illelag reference Id");

        }
    }

}
