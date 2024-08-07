package hello.helloSpring.web.notice.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.helloSpring.web.notice.dto.NoticeResponse;
import hello.helloSpring.web.notice.model.QNotice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PageableNoticeImpl implements PageableNotice{
    private final JPAQueryFactory jpaQueryFactory;
    QNotice Qn = QNotice.notice;
    @Override
    public Page<NoticeResponse> searchPage(String title, String searchNum, Pageable pageable) {
       System.out.println("Integer.parseInt(searchNum)-1="+searchNum);

        JPAQuery<Tuple> query= jpaQueryFactory.select(
                        Qn.noticeId,
                        Qn.title,
                        Qn.content,
                        Qn.insertDt,
                        Qn.updateDt)
                .from(Qn)
                .where( titleEq(title))
                .offset((Integer.parseInt(searchNum)-1)*10)
                .limit(10)
                .orderBy(Qn.noticeId.desc());


        List<NoticeResponse> content=  query.fetch().stream().map(tuple -> NoticeResponse.builder()
                .noticeId(tuple.get(Qn.noticeId))
                .title(tuple.get(Qn.title))
                .content(tuple.get(Qn.content))
                .insertDt(tuple.get(Qn.insertDt))
                .updateDt(tuple.get(Qn.updateDt))
                .build()).collect(Collectors.toList());
    System.out.println("content="+content);
      Long count = jpaQueryFactory.select(
                        Qn.count())
                .from(Qn)
                .where( titleEq(title)).fetchOne();


        int total= Long.valueOf(count).intValue();
        System.out.println("count="+total);
        return new PageImpl<>(content, pageable, total);
    }

    public BooleanExpression titleEq(String title){

        if(StringUtils.isEmpty(title))
        {
            return null;
        }
        return Qn.title.contains(title);
    }
}
