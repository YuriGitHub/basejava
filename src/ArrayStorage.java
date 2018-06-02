/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        this.storage = new Resume[10000];
    }

    void save(Resume r) {
        int length = this.size();
        storage[length] = r;
    }

    Resume get(String uuid) {
        for (Resume resume : this.storage){
            if(resume.uuid.equals(uuid))
                return resume;
        }
        return null;
    }

    void delete(String uuid) {
        int indexForDelete = -1;
        for (int i = 0; i < storage.length; i++){
            if(storage[i].uuid.equals(uuid)){
                indexForDelete = i;
                break;
            }
        }
        if(indexForDelete != -1){
            int lastIndex = size() - 1;
            if(lastIndex >= 0){
                Resume lastResume = storage[lastIndex];
                storage[indexForDelete] = lastResume;
                storage[lastIndex] = null;
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] res = new Resume[size()];
        System.arraycopy(storage, 0, res, 0, size());
        return res;
    }

    int size() {
        int length = 0;
        for (Resume aStorage : this.storage) {
            if (aStorage == null)
                break;
            length++;
        }
        return length;
    }
}
