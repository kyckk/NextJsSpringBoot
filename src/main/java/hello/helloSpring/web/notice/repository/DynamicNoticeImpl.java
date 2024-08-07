package hello.helloSpring.web.notice.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.helloSpring.web.notice.model.Notice;
import hello.helloSpring.web.notice.model.QNotice;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DynamicNoticeImpl implements DynamicNotice {

    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public List<Notice> findNoticeByTilte() {
        QNotice Qn = QNotice.notice;
        JPAQuery<Tuple> query= jpaQueryFactory.select(
                Qn.noticeId,
                Qn.title,
                Qn.content,
                Qn.insertDt,
                Qn.updateDt)
                .from(Qn)
                .where(Qn.title.contains("테스트"))
                .orderBy(Qn.noticeId.desc());


        return  query.fetch().stream().map(tuple -> Notice.builder()
                .noticeId(tuple.get(Qn.noticeId))
                .title(tuple.get(Qn.title))
                .content(tuple.get(Qn.content))
                .insertDt(tuple.get(Qn.insertDt))
                .updateDt(tuple.get(Qn.updateDt))
                .build()).collect(Collectors.toList());
    }
}
