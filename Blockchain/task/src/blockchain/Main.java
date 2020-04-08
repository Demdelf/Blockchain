package blockchain;


import org.jetbrains.annotations.NotNull;

import java.security.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class Main {
    static StringBuilder chat = new StringBuilder();
    //static List<String> stringList = new ArrayList<>();
    volatile int hash = 0;
    static AtomicInteger messageNumber = new AtomicInteger(1);
    static List<List<Message>> messagesList;
    static PublicKey pk;
    public static void main(String[] args) throws InterruptedException {

       /* TreeSet<String> algorithms = new TreeSet<>();
        for (Provider provider : Security.getProviders())
            for (Provider.Service service : provider.getServices())
                if (service.getType().equals("Signature"))
                    algorithms.add(service.getAlgorithm());
        for (String algorithm : algorithms)
            System.out.println(algorithm);*/

        LocalTime timeStart = LocalTime.now();

        BlockChain blockChain = new BlockChain();

        /*stringList.add('\n' +"Tom: Hey, I'm first!");
        stringList.add('\n' +"Sarah: It's not fair!");
        stringList.add('\n' +"Sarah: You always will be first because it is your blockchain!");
        stringList.add('\n' +"Sarah: Anyway, thank you for this amazing chat");
        stringList.add('\n' +"Tom: You're welcome :)");
        stringList.add('\n' +"Nick: Hey Tom, nice chat");*/

        try {
            SignatureHelper signatureHelper = new SignatureHelper(512);
            signatureHelper.createKeys();
            PrivateKey sk = signatureHelper.getPrivateKey();
            pk = signatureHelper.getPublicKey();

            messagesList = generateMessages(sk);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //ExecutorService executor = null;
        AtomicInteger x = new AtomicInteger(1);

        /**Multy by parallel Stream**/
        Stream.generate(() -> new Miner(x.getAndIncrement(), blockChain)).limit(10).parallel().map(m -> {
            List<Block> blocks = new ArrayList<>();
            while (blockChain.getBlocks().size() < 15){
                Block block = null;
                try {
                    block = m.generateBlock();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                } catch (SignatureException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                blockChain.addBlock(block);
                //if(blockChain.addBlock(block)) System.out.println(block);;
                blocks.add(block);
            }

            return blocks;
        }).count();

        /**Multy by Executors**/
        /*for (int j = 0; j < 15; j++){
            executor = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 5; i++) {

                executor.submit(() -> {
                    //System.out.println(Thread.currentThread().getName());
                    Miner miner = new Miner(Integer.parseInt(Thread.currentThread().getName().split("-")[3]), blockChain);
                    Block block = null;
                    try {
                        block = miner.generateBlock();
                    } catch (InvalidKeyException e) {
                        e.printStackTrace();
                    } catch (SignatureException e) {
                        e.printStackTrace();
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                    blockChain.addBlock(block);
                    //miner.run();
                });
                //executor.execute();
            }

            executor.shutdown();
            //Thread.sleep(1500);
            executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
        }



        executor.shutdownNow();
        //Thread.sleep(1500);
        executor.awaitTermination(4000, TimeUnit.MILLISECONDS);*/
        int c = 0;
        for (Block b: blockChain.getBlocks()
        ) {
            System.out.println(b);

        }
        int time = LocalTime.now().toSecondOfDay() - timeStart.toSecondOfDay();
        //System.out.println("Time: " + time);
    }
    @NotNull
    private static List<List<Message>> generateMessages(PrivateKey privateKey) throws Exception {
        return List.of(
                List.of(),
                List.of(new Message('\n' +"miner9 sent 30 VC to miner1", messageNumber.getAndIncrement(), privateKey)),
                List.of(new Message('\n' +"miner9 sent 30 VC to miner2", messageNumber.getAndIncrement(), privateKey)),
                List.of(new Message('\n' +"miner9 sent 30 VC to Nick", messageNumber.getAndIncrement(), privateKey),
                        new Message('\n' +"miner9 sent 10 VC to Bob", messageNumber.getAndIncrement(), privateKey),
                        new Message('\n' +"miner7 sent 10 VC to Alice", messageNumber.getAndIncrement(), privateKey)),
                List.of(new Message('\n' +"Nick sent 1 VC to ShoesShop", messageNumber.getAndIncrement(), privateKey),
                        new Message('\n' +"Nick sent 2 VC to FastFood", messageNumber.getAndIncrement(), privateKey)),
                List.of(/*new Message() {
                    @Override
                    public byte[] getSignature() {
                        return new byte[256];
                    }

                    @Override
                    public long getUid() {
                        return 100_500;
                    }

                    @Override
                    public String getMessage() {
                        return "hacker!";
                    }
                }*/),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of());

    }

    static class StringUtil {

        public static String applySha256(String input){
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                /* Applies sha256 to our input */
                byte[] hash = digest.digest(input.getBytes("UTF-8"));
                StringBuilder hexString = new StringBuilder();
                for (byte elem: hash) {
                    String hex = Integer.toHexString(0xff & elem);
                    if(hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                return hexString.toString();
            }
            catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class BlockChain{
        private ArrayList<Block> blocks = new ArrayList<>();
        private int n;

        public int getN() {
            return n;
        }
        public void setN(int n) {
            this.n = n;
        }

        public synchronized ArrayList<Block> getBlocks() {
            return blocks;
        }

        /*public void generateBlock(){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++){
                stringBuilder.append("0");
            }
            long timeStamp = new Date().getTime();
            if (blocks.isEmpty()){
                int id = 1;

                String hash = "";
                LocalTime timeStart = LocalTime.now();
                int magic = 0;
                do {
                    magic = (int) (Math.random()*100_000_000);
                    hash = StringUtil.applySha256("New block with id " + id + " and timeStamp " + timeStamp + magic);
                }while (!hash.startsWith(stringBuilder.toString()));

                int time = LocalTime.now().toSecondOfDay() - timeStart.toSecondOfDay();
                Block block = new Block(id, timeStamp, magic, "0", hash, time);
                blocks.add(block);
            } else {
                int id = blocks.get(blocks.size() - 1).getId() + 1;
                //long timeStamp = new Date().getTime();
                //String hash = StringUtil.applySha256("New block with id " + id + " and timeStamp " + timeStamp, n);
                String hash = "";
                LocalTime timeStart = LocalTime.now();
                int magic = 0;

                do {
                    magic = (int) (Math.random()*100_000_000);
                    hash = StringUtil.applySha256("New block with id " + id + " and timeStamp " + timeStamp + magic);
                }while (!hash.startsWith(stringBuilder.toString()));

                int time = LocalTime.now().toSecondOfDay() - timeStart.toSecondOfDay();
                String preHash = blocks.get(blocks.size() - 1).getHash();
                Block block = new Block(id, timeStamp, magic, preHash, hash, time);
                blocks.add(block);
            }
        }*/
        public synchronized boolean addBlock(Block block){
            boolean flag = isValidBlock(block);
            if (flag){
                if (block.time < 1 && n < 4) n++;
                else if (block.time >= 2) n--;
                block.setN(n);
                blocks.add(block);
            }
            return flag;
        }
        public boolean isValidBlock(Block block){
            boolean flag = true;
            if(blocks.size() > 0){
                if (!block.preHash.equals(blocks.get(blocks.size() - 1).hash)) flag = false;
                if (block.id != blocks.get(blocks.size() - 1).id + 1) flag = false;
            }
            return flag;
        }

        public synchronized boolean isValid(){
            for (int i = 1; i < blocks.size(); i++){
                if (!blocks.get(i).getHash().equals(blocks.get(i - 1).getHash())) return false;
            }
            return true;
        }
    }

    static class Miner extends Thread{
        BlockChain blockChain;
        int number;

        public Miner(int number, BlockChain blockChain) {
            this.number = number;
            this.blockChain = blockChain;
        }

        @Override
        public void run() {
            Block block = null;
            try {
                block = generateBlock();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (SignatureException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            blockChain.addBlock(block);
        }
        public synchronized Block generateBlock() throws InvalidKeyException, SignatureException, NoSuchAlgorithmException {
            StringBuilder stringBuilder = new StringBuilder();
            String data = "";
            for (int i = 0; i < blockChain.getN(); i++){
                stringBuilder.append("0");
            }
            long timeStamp = new Date().getTime();
            if (blockChain.getBlocks().isEmpty()){
                int id = 1;

                String hash = "";
                LocalTime timeStart = LocalTime.now();
                int magic = 0;
                //do {
                magic = (int) (Math.random()*100_000_000);
                hash = StringUtil.applySha256("New block with id " + id + " and timeStamp " + timeStamp + magic);
                //}while (!hash.startsWith(stringBuilder.toString()));

                int time = LocalTime.now().toSecondOfDay() - timeStart.toSecondOfDay();
                Block block = new Block(id, timeStamp, magic, "0", hash, time, this, " no messages");
                return block;
            } else {
                int id = blockChain.getBlocks().get(blockChain.getBlocks().size() - 1).getId() + 1;
                //long timeStamp = new Date().getTime();
                //String hash = StringUtil.applySha256("New block with id " + id + " and timeStamp " + timeStamp, n);
                String hash = "";
                LocalTime timeStart = LocalTime.now();
                int magic = 0;

                do {
                    magic = (int) (Math.random()*100_000_000);
                    hash = StringUtil.applySha256("New block with id " + id + " and timeStamp " + timeStamp + magic);
                }while (!hash.startsWith(stringBuilder.toString()));

                for (Message m: messagesList.get(id)
                ) {


                    m.signature.initVerify(pk);
                    m.signature.update(m.text.getBytes());

                    if (m.signature.verify(m.bs))
                        chat.append(m.text);
                }
                data = chat.toString();
                chat = new StringBuilder();
                int time = LocalTime.now().toSecondOfDay() - timeStart.toSecondOfDay();
                String preHash = blockChain.getBlocks().get(blockChain.getBlocks().size() - 1).getHash();
                Block block = new Block(id, timeStamp, magic, preHash, hash, time, this, data);
                return  block;
            }
        }
    }
    static class Block{
        private int id;
        private long timeStamp;
        private int magicNumber;
        private String preHash;
        private String hash;
        private int time;
        private String data;
        private Miner miner;

        public void setN(int n) {
            this.n = n;
        }

        private int n;

        public Block(int id, long timeStamp, int magicNumber, String preHash, String hash, int time, Miner miner, String data) {
            this.id = id;
            this.timeStamp = timeStamp;
            this.magicNumber = magicNumber;
            this.preHash = preHash;
            this.hash = hash;
            this.time = time;
            this.miner = miner;
            this.data = data;
        }
        public void setMiner(Miner miner) {
            this.miner = miner;
        }
        public synchronized int getId() {
            return id;
        }

        public synchronized void setId(int id) {
            this.id = id;
        }

        public long getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getPreHash() {
            return preHash;
        }

        public void setPreHash(String preHash) {
            this.preHash = preHash;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        @Override
        public String toString() {
            String aboutN = "N stays the same";
            if (time < 1) aboutN = "N was increased to " + n;
            else if(time >= 2) aboutN = "N was decreased by 1" ;
            return "Block:" + '\n' +
                    "Created by: miner" + miner.number + '\n' +
                    "miner" + miner.number + " gets 100 VC" + '\n' +
                    "Id: " + id + '\n' +
                    "Timestamp: " + timeStamp + '\n' +
                    "Magic number: " + magicNumber + '\n' +
                    "Hash of the previous block:" + '\n' + preHash + '\n' +
                    "Hash of the block:" + '\n' + hash + '\n' +
                    "Block data:"  + data + '\n' +
                    "Block was generating for " + time + " seconds" + '\n' +
                    aboutN + '\n';
        }
    }
    static class Message{
        String text;
        int number;

        Signature signature;
        byte[] bs;

        public Message(String text, int number, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
            this.text = text;
            this.number = number;
            this.signature = Signature.getInstance("SHA1withDSA");
            //SecureRandom secureRandom = new SecureRandom();
            this.signature.initSign(privateKey);
            this.signature.update(text.getBytes());
            this.bs = signature.sign();
        }
    }
    /*static class Transaction{
     *//*Miner sender;
        Miner receiver;
        int sum;*//*

        String text;

        Signature signature;
        byte[] bs;

        public Transaction(String text, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
            this.text = text;
            this.signature = Signature.getInstance("SHA1withDSA");

            this.signature.initSign(privateKey);
            this.signature.update(text.getBytes());
            this.bs = signature.sign();
        }
    }*/
}


