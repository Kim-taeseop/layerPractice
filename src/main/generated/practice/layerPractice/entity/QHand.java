package practice.layerPractice.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHand is a Querydsl query type for Hand
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHand extends EntityPathBase<Hand> {

    private static final long serialVersionUID = -1594819707L;

    public static final QHand hand = new QHand("hand");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QHand(String variable) {
        super(Hand.class, forVariable(variable));
    }

    public QHand(Path<? extends Hand> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHand(PathMetadata metadata) {
        super(Hand.class, metadata);
    }

}

