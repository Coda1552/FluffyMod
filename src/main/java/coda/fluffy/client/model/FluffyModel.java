package coda.fluffy.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.TamableAnimal;

public class FluffyModel<T extends TamableAnimal> extends EntityModel<T> {
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart rightEar;
	private final ModelPart leftEar;
	private final ModelPart tail;
	private final ModelPart tail2;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;
	private final ModelPart backLeftLeg;
	private final ModelPart backRightLeg;

	public FluffyModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = body.getChild("head");
		this.rightEar = head.getChild("rightEar");
		this.leftEar = head.getChild("leftEar");
		this.tail = body.getChild("tail");
		this.tail2 = tail.getChild("tail2");
		this.rightLeg = body.getChild("rightLeg");
		this.leftLeg = body.getChild("leftLeg");
		this.backRightLeg = body.getChild("backRightLeg");
		this.backLeftLeg = body.getChild("backLeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -3.0F, -9.0F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 7.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(13, 17).addBox(-2.5F, -2.0F, -4.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -9.0F));

		PartDefinition rightEar = head.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(0, 18).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.0F, -1.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition leftEar = head.addOrReplaceChild("leftEar", CubeListBuilder.create().texOffs(0, 18).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -1.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(16, 25).addBox(-1.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 2.0F, -5.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(24, 25).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, -2.5F, 0.6109F, 0.0F, 0.0F));

		PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 11).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.5F, 0.3927F, 0.0F, 0.0F));

		PartDefinition backLeftLeg = body.addOrReplaceChild("backLeftLeg", CubeListBuilder.create().texOffs(0, 25).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 1.0F, -3.0F));

		PartDefinition backRightLeg = body.addOrReplaceChild("backRightLeg", CubeListBuilder.create().texOffs(0, 25).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 1.0F, -3.0F));

		PartDefinition rightLeg = body.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(8, 26).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 1.0F, -8.0F));

		PartDefinition leftLeg = body.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(8, 26).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 1.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		limbSwingAmount = Mth.clamp(limbSwingAmount, -0.35F, 0.35F);

		this.head.xRot += headPitch * ((float)Math.PI / 180F);
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.tail.yRot = Mth.sin(-1.0F + ageInTicks * 0.35F) * 0.35F * 0.5F;
		this.tail2.yRot = Mth.sin(-1.0F + ageInTicks * 0.35F) * 0.35F * 0.5F;

		if (entity.isInSittingPose()) {
			this.head.zRot = 0.0F;
			this.head.xRot = 0.0F;
			this.head.y = -1.5F;

			this.body.zRot = 0.0F;
			this.body.y = 22.5F;

			this.tail.xRot = 0.5F;
			this.tail2.xRot = 0.85F;

			this.leftEar.y = -0.5F;
			this.rightEar.y = -0.5F;

			this.backRightLeg.xRot = -1.5708F;
			this.backLeftLeg.xRot = -1.5708F;
			this.rightLeg.xRot = -1.5708F;
			this.leftLeg.xRot = -1.5708F;

			this.backRightLeg.yRot = 1.35F;
			this.backLeftLeg.yRot = -1.35F;
			this.rightLeg.yRot = 1.0F;
			this.leftLeg.yRot = -1.0F;

		}
		else {

			this.head.zRot = Mth.sin(-1.0F + limbSwing * 0.35F) * limbSwingAmount * 0.5F;
			this.head.xRot = Mth.sin(-1.0F + limbSwing * 0.7F) * limbSwingAmount * 0.15F;
			this.head.y = Mth.sin(-1.0F + limbSwing * 0.7F) * limbSwingAmount * 0.15F - 1.5F;

			this.body.zRot = Mth.sin(limbSwing * 0.7F) * limbSwingAmount * 0.15F;
			this.body.y = 20.0F;

			this.tail.xRot = 0.6109F;
			this.tail2.xRot = 0.3927F;

			this.leftEar.y = Mth.sin(-2.0F + limbSwing * 0.7F) * limbSwingAmount * 0.8F - 0.5F;
			this.rightEar.y = Mth.sin(-2.0F + limbSwing * 0.7F) * limbSwingAmount * 0.8F - 0.5F;

			this.backRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.backLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

			this.backRightLeg.yRot = 0.0F;
			this.backLeftLeg.yRot = 0.0F;
			this.rightLeg.yRot = 0.0F;
			this.leftLeg.yRot = 0.0F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}