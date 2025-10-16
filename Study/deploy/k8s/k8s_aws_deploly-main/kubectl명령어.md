### Pod 실행
```
kubectl run boot-kube --image bmsvega2k/boot-kube:0.1
```
### Pod 목록 확인
```
kubectl get pod 
kubectl get po
```

### Pod 상세정보 확인
```
kubectl describe pod/boot-kube 
```

### Pod 내부로 들어가기
```
kubectl exec -it boot-kube -- sh
```

### Pod 삭제하기
```
kubectl delete pod/boot-kube
```

### yml 파일로 Pod 실행 및 삭제하기
```
kubectl apply -f ./k8s/boot-kube-pod.yml

kubectl delete -f ./k8s/boot-kube-pod.ym
```

### Pod와 ReplicaSet 목록 확인
```
kubectl get po,rs 
```

### Deployment 에 적용된 Image 를 변경하기
```
kubectl set image deployment/boot-kube-deploy boot-kube=bmsvega2k/boot-kube:0.3
```

### Deployment 의 Revision 목록 확인하기
```
kubectl rollout history deploy
```

### Deployment 의 Revision2로 롤백하기
```
kubectl rollout undo deployment/boot-kube-deploy --to-revision=2
```

