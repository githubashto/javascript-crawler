package com.zyd.ncore.busi;

import java.util.HashSet;
import java.util.List;

import junit.framework.TestCase;

import com.zyd.ncore.dom.Book;
import com.zyd.ncore.dom.Chapter;

public class TestJSonMapper extends TestCase {
    JSonMapper jm;

    @Override
    protected void setUp() throws Exception {
        jm = JSonMapper.getInstance();
    }

    public void testParseBookList() {
        String s = ATestData.book4;
        String[] names = new String[] { "���", "˭��˭ħ", "�������", "��Ʒ͵����", "����Ŀ¼֮�ҵ�ǰ���ǽ���", "����֮�л���ϵ", "�ʻ�����ţ����", "����ʥ��", "���֮ɥʬ�ٻ�", "ս����˵", "����֮��ʿ����", "���߹���֮�����ֻ�", "������;", "֤���", "���½�˵", "ĩ��֮ɥʬ����",
                "��ɫ����", "�����", "��Ц������", "������", "����֮����", "��λ����żȻ", "�������", "����", "����֮����ݺ�", "ħ��Ӣ�۴�", "���֮��������", "��Խ�ع�֮����", "а���", "ӡ��ʦ����", "Ư��Ů�ҽ�", "��ʱ", "������", "Ĺ��", "Ī��·", "Ī������", "����������",
                "ħ������֮��ĺ֮��", "�Ҷ���Ұ��", "˫����", "���Ͼ�ʷ����", "���綦��", "����", "�취��", "����������", "һ������", "Ǳ����Ӱ", "����֮����һ��", "����Ҳ��һ������", "���鴫", "�ǻ�֮��", "����֮��ת����", "��Īͣ", "��·����", "�������", "����", "ĩ������", "�����Ӱ�",
                "��Ʒսʿ", "�׳���", "����֮��������", "������", "������Ե", "����֮��˴���", "������", "�ޱ���ħ������", "������", "������", "�����۾���", "��ɱ����ʿ", "����Ϸ", "��˵һ���Ҳ���Ů��", "������ʦ", "�����", "�ڰ��¼�Ԫ", "�Ƽ�Ů��", "��������", "�з紫˵", "����֮Ǳ����ˮ",
                "����", "����֮�������˴�", "�Ƿ�У԰", "����֮Ȩ������", "����һ��å����", "����������", "���ʽ�", "��Ʒ��̨", "�����ؽ�", "������", "��������", "ͼ����ʿ", "�ִ����¼", "����֮��ս����", "���֮��", "����֮��������", "����ɽ�µĴ���", "��Ѫ��У", "ħ����", "��Ұãã", "��������" };
        String[] authors = new String[] { "�������ʹ", "С���ķ�", "�����", "�����", "�������ɷ�...", "��С˵�Ŀ���", "����һ֦��", "ʥ��", "��н��ǧ��", "���վ�Ҫ��...", "���", "��Ӱ��", "͵�Զ���", "������Ϫ", "���ֺ��а�", "���ǹ��", "��������", "����������", "����",
                "��ذ", "��åд��", "ҹ�����", "����", "��������", "��֮��", "�ǳ����", "����а", "Sky����", "��������", "һյ��", "Ľ����", "����", "��������", "������", "���ɷ�", "骹Ͼ�", "������", "������Ĺ԰", "����ʤ", "����", "��־��", "�������", "������",
                "���Ķ���...", "�˰���ǧ����", "����", "����", "ظ��K", "��˹��", "������", "������", "����", "����", "���ѽ��Ұ�", "����", "����ʱ��", "�������", "վ���Ļƺ�", "��������", "����δ��", "�����", "�����ڻ���", "������ţ׷...", "���°�����", "���ɷ�", "������ү",
                "��ħǿ", "������", "��������", "���ϲ�", "�������", "�����", "��į��ʯͷ", "�����", "����ȱ", "��������", "��������", "��֮��", "��������811", "���з���", "�׹���", "����С����", "Ҷ����", "����", "īС��", "ǳǳ��", "������Ұ", "Ѫɫ����", "������", "�׺�����",
                "������", "������ˮ", "����", "����ī��", "����", "��������", "ɵɵ�ν���", "�ٲ���", "����", "��˫��" };
        String[] links = new String[] { "http://www.qidian.com/Book/1156308.aspx", "http://www.qidian.com/Book/1289050.aspx", "http://www.qidian.com/Book/1361200.aspx",
                "http://www.qidian.com/Book/1383445.aspx", "http://www.qidian.com/Book/1387552.aspx", "http://www.qidian.com/Book/1389049.aspx", "http://www.qidian.com/Book/113446.aspx",
                "http://www.qidian.com/Book/1346598.aspx", "http://www.qidian.com/Book/1389768.aspx", "http://www.qidian.com/Book/1391683.aspx", "http://www.qidian.com/Book/1375950.aspx",
                "http://www.qidian.com/Book/1387375.aspx", "http://www.qidian.com/Book/1374236.aspx", "http://www.qidian.com/Book/1367804.aspx", "http://www.qidian.com/Book/1361752.aspx",
                "http://www.qidian.com/Book/1371191.aspx", "http://www.qidian.com/Book/1048205.aspx", "http://www.qidian.com/Book/1392745.aspx", "http://www.qidian.com/Book/1388503.aspx",
                "http://www.qidian.com/Book/1287884.aspx", "http://www.qidian.com/Book/1367882.aspx", "http://www.qidian.com/Book/1380167.aspx", "http://www.qidian.com/Book/1354118.aspx",
                "http://www.qidian.com/Book/1392322.aspx", "http://www.qidian.com/Book/1385690.aspx", "http://www.qidian.com/Book/1309242.aspx", "http://www.qidian.com/Book/1342521.aspx",
                "http://www.qidian.com/Book/1390623.aspx", "http://www.qidian.com/Book/1392742.aspx", "http://www.qidian.com/Book/1390848.aspx", "http://www.qidian.com/Book/66912.aspx",
                "http://www.qidian.com/Book/1389960.aspx", "http://www.qidian.com/Book/1377586.aspx", "http://www.qidian.com/Book/1356801.aspx", "http://www.qidian.com/Book/1375462.aspx",
                "http://www.qidian.com/Book/1368596.aspx", "http://www.qidian.com/Book/1216409.aspx", "http://www.qidian.com/Book/1243682.aspx", "http://www.qidian.com/Book/1333118.aspx",
                "http://www.qidian.com/Book/1298236.aspx", "http://www.qidian.com/Book/30994.aspx", "http://www.qidian.com/Book/1392551.aspx", "http://www.qidian.com/Book/1363420.aspx",
                "http://www.qidian.com/Book/1371440.aspx", "http://www.qidian.com/Book/1363504.aspx", "http://www.qidian.com/Book/1392226.aspx", "http://www.qidian.com/Book/1121826.aspx",
                "http://www.qidian.com/Book/1392127.aspx", "http://www.qidian.com/Book/1370786.aspx", "http://www.qidian.com/Book/1051964.aspx", "http://www.qidian.com/Book/1347686.aspx",
                "http://www.qidian.com/Book/1392208.aspx", "http://www.qidian.com/Book/1227085.aspx", "http://www.qidian.com/Book/1385737.aspx", "http://www.qidian.com/Book/1391721.aspx",
                "http://www.qidian.com/Book/1390543.aspx", "http://www.qidian.com/Book/1381751.aspx", "http://www.qidian.com/Book/1332450.aspx", "http://www.qidian.com/Book/1102847.aspx",
                "http://www.qidian.com/Book/1386013.aspx", "http://www.qidian.com/Book/1229431.aspx", "http://www.qidian.com/Book/1390273.aspx", "http://www.qidian.com/Book/1360158.aspx",
                "http://www.qidian.com/Book/1204680.aspx", "http://www.qidian.com/Book/1390146.aspx", "http://www.qidian.com/Book/1391492.aspx", "http://www.qidian.com/Book/1391976.aspx",
                "http://www.qidian.com/Book/1374366.aspx", "http://www.qidian.com/Book/1391962.aspx", "http://www.qidian.com/Book/1390605.aspx", "http://www.qidian.com/Book/1387870.aspx",
                "http://www.qidian.com/Book/1261750.aspx", "http://www.qidian.com/Book/1257268.aspx", "http://www.qidian.com/Book/1307465.aspx", "http://www.qidian.com/Book/1370779.aspx",
                "http://www.qidian.com/Book/1390428.aspx", "http://www.qidian.com/Book/1389707.aspx", "http://www.qidian.com/Book/1359538.aspx", "http://www.qidian.com/Book/1386798.aspx",
                "http://www.qidian.com/Book/1392276.aspx", "http://www.qidian.com/Book/1390022.aspx", "http://www.qidian.com/Book/1378413.aspx", "http://www.qidian.com/Book/1315829.aspx",
                "http://www.qidian.com/Book/1348829.aspx", "http://www.qidian.com/Book/1373739.aspx", "http://www.qidian.com/Book/1328396.aspx", "http://www.qidian.com/Book/1081725.aspx",
                "http://www.qidian.com/Book/1389914.aspx", "http://www.qidian.com/Book/1391984.aspx", "http://www.qidian.com/Book/1382876.aspx", "http://www.qidian.com/Book/1226369.aspx",
                "http://www.qidian.com/Book/1388512.aspx", "http://www.qidian.com/Book/1366725.aspx", "http://www.qidian.com/Book/1387353.aspx", "http://www.qidian.com/Book/1348150.aspx",
                "http://www.qidian.com/Book/1034992.aspx", "http://www.qidian.com/Book/1384475.aspx", "http://www.qidian.com/Book/96434.aspx", "http://www.qidian.com/Book/1387632.aspx",
                "http://www.qidian.com/Book/1372650.aspx" };
        String[] categories = new String[] { "��������", "�ŵ�����", "�ܿ���ʷ", "�������", "����ͬ��", "����½", "��������", "�������", "����½", "��������", "��������", "��������", "�������", "�ŵ�����", "�������", "��������", "�������", "�ִ�����", "�ŵ�����",
                "�ٳ�����", "�غ�����", "��������", "��������", "�������", "��������", "�������", "����½", "ְ����־", "�������", "�������", "��������", "����½", "�������", "������̸", "��Թ���", "����½", "�������", "��������", "�����ʷ", "��������", "��ʷ����", "�ŵ�����",
                "�ٳ�����", "������̸", "�ŵ�����", "��Թ���", "����½", "��������", "��������", "��ͳ����", "��������", "����½", "��ͳ����", "��������", "�������", "�������", "��������", "�ļ�����", "��������", "��������", "����Ԫ��", "�������", "�������", "��������", "��������",
                "����½", "����½", "��ͳ����", "����Ԫ��", "����½", "��������", "�ഺУ԰", "�������", "��������", "����½", "δ������", "��������", "�ŵ�����", "��������", "�ŵ�����", "��������", "��������", "�ٳ�����", "����½", "��������", "��������", "�������", "����½",
                "�������", "��ͳ����", "��������", "�������", "�ܿ���ʷ", "�������", "δ������", "�����ս", "�ഺУ԰", "��������", "��������", "����½" };
        String[] totalChar = new String[] { "749122", "206542", "84288", "99288", "30327", "30576", "30712", "84538", "41840", "13090", "77827", "46882", "38154", "218712", "176111", "29862",
                "37977", "2162", "49467", "221416", "38951", "6530", "301769", "9142", "19409", "60421", "226580", "11743", "3550", "14985", "145806", "18707", "79442", "99786", "60003", "129900",
                "321291", "332481", "162504", "205522", "485364", "17401", "212929", "26013", "59470", "10215", "25002", "5152", "68511", "67949", "121675", "36973", "29116", "47950", "9513",
                "15668", "34668", "165060", "195449", "87865", "1435214", "4964", "197536", "1749757", "23237", "14361", "8611", "74482", "15034", "8392", "32389", "177270", "1026991", "33610",
                "58096", "12284", "23255", "71110", "54388", "121624", "24917", "20885", "435930", "172708", "24881", "0", "14705", "15419", "4718", "41755", "328915", "4827", "58643", "9672",
                "236701", "167363", "52190", "17740", "21872", "67620" };
        HashSet<Book> bookSet = new HashSet<Book>();
        for (int i = 0; i < names.length; i++) {
            Book book = new Book();
            book.setName(names[i]);
            book.setAuthor(authors[i]);
            book.setAllChapterUrl(links[i]);
            book.setCategory(categories[i]);
            book.setTotalChar(Integer.parseInt(totalChar[i]));
            bookSet.add(book);
        }
        List<Book> list = jm.parseBookList(s);
        assertEquals(100, list.size());
        for (Book book : list) {
            assertNotNull(bookSet.remove(book));
        }        
        assertEquals(0, bookSet.size());
    }

    public void testParseBookWithChapter() {
        String s = ATestData.bookchapters;
        Book book = jm.parseBook(s);
        assertNotNull(book);
        assertNotNull(book.getName());
        assertNotNull(book.getAuthor());
        assertTrue(book.getName().toLowerCase().indexOf("error") < 0);
        assertNotNull(book.getChapters());
        assertEquals(500, book.getChapters().size());
        for (Chapter c : book.getChapters()) {
            String url = c.getChapterUrl();
            assertNotNull(url);
            assertNotNull(c.getName());
            assertTrue(s.indexOf(url) > 0);
        }
    }

    public void testBookHash() {
        Book b1 = new Book();
        b1.setName("boo1name");
        b1.setAuthor("b1author");

        Book b2 = new Book();
        b2.setName(b1.getName());
        b2.setAuthor(b1.getAuthor());

        assertEquals(b1.hashCode(), b2.hashCode());
        assertEquals(b1, b2);

        HashSet<Book> set = new HashSet<Book>();
        set.add(b1);
        set.remove(b2);
        assertEquals(0, set.size());
    }
}
