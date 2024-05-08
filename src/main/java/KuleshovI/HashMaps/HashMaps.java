package KuleshovI.HashMaps;

public class HashMaps<K, V> {

    public static final int INIT_BUCKET_COUNT = 16;
    private Bucket[] buckets; // Примечание: массив корзин

    /*
    Entity - элемент хэш-таблицы
    */
    class Entity {
        K key;
        V value;

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    /*
    Bucket - связанный список
    */
    class Bucket {
        class Node {
            /*
            next - Указатель на следующий элемент
             */
            Node next;

            /*
            Значение узла, указывающего на элемент
             */
            Entity value;
        }

        private Node head;

        public V add(Entity entity) {
            Node node = new Node();
            node.value = entity;
            if (head == null) {
                head = node;
                return null;
            }
            Node currentNode = head;
            while (true) {
                if (currentNode.value.key.equals(entity.key)) {
                    V buf = currentNode.value.value;
                    currentNode.value.value = entity.value;
                    return buf;
                }
                if (currentNode.next != null) {
                    currentNode = currentNode.next;
                } else {
                    currentNode.next = node;
                    return null;
                }
            }
        }
/*
переопределение toString() для печати содержимого корзины
 */
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            Node currentNode = head;
            while (currentNode != null) {
                builder.append(currentNode.value.toString());
                if (currentNode.next != null) {
                    builder.append(", ");
                }
                currentNode = currentNode.next;
            }
            builder.append("]");
            return builder.toString();
        }
    }

    private int calculateBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public V put(K key, V value) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null) {
            bucket = new Bucket();
            buckets[index] = bucket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;

        return bucket.add(entity);
    }
    /*
    Узел бакета, связанного списка
    */
    @SuppressWarnings("unchecked")
    public HashMaps(int i) {
        buckets = (Bucket[]) new HashMaps.Bucket[INIT_BUCKET_COUNT];
    }


    public V get(K key) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket != null) {
            Bucket.Node currentNode = bucket.head;
            while (currentNode != null) {
                if (currentNode.value.key.equals(key)) {
                    return currentNode.value.value;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                result.append(buckets[i].toString());
                if (i < buckets.length - 1 && buckets[i + 1] != null) {
                    result.append(", ");
                }
            }
        }
        result.append("]");
        return result.toString();
    }
}