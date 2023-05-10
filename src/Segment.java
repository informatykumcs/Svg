public class Segment {
    private Vec2 startPoint;
    private Vec2 endPoint;

    public Segment(Vec2 startPoint, Vec2 endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public double getLength() {
        double dx = startPoint.x - endPoint.x;
        double dy = startPoint.y - endPoint.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Vec2 getStartPoint() {
        return startPoint;
    }

    public Vec2 getEndPoint() {
        return endPoint;
    }


    public String toSvg() {
        return "<line x1=\"" + startPoint.x + "\" y1=\"" + startPoint.y +
                "\" x2=\"" + endPoint.x + "\" y2=\"" + endPoint.y +
                "\" stroke=\"black\" stroke-width=\"2\"/>";
    }
    public static Segment[] perpendicularSegment(Segment segment, Vec2 point){
        Segment segmentA = new Segment(point,point);
        Segment segmentB = new Segment(point,point);
        return new Segment[] {segmentA, segmentB};
    }

}
